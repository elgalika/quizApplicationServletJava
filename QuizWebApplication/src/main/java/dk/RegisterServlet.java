package dk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            // Validate data (add your validation logic here)
            if (username.length() < 1 || password.length() < 8 || email.length() < 1) {
                // Redirect to an error page for invalid input
                response.sendRedirect("registration-error.jsp");
                return;
            }

            // Check if the username or email is already registered
            if (isUserRegistered(username, email)) {
                // Redirect to an error page indicating that username or email is already registered
                response.sendRedirect("registration-error-duplicate.jsp");
                return;
            }

            // Store user information in the database
            Connection connection = DatabaseManager.getConnection();
            String query = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.executeUpdate();

                // Retrieve the generated keys (including the user ID)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        // Now you have the ID of the newly inserted user (userId)
                    }
                }
            }
            DatabaseManager.closeConnection(connection);

            // Redirect to a success page or login page
            response.sendRedirect("Login.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Redirect to an error page
            response.sendRedirect("registration-error.jsp");
        }
    }

    private boolean isUserRegistered(String username, String email) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String query = "SELECT * FROM Users WHERE username = ? OR email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if the username or email is already registered
            }
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }
}
