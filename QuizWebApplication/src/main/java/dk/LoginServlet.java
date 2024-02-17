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
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Authenticate user (add your authentication logic here)
            int userId = authenticateAndGetUserId(username, password);

            if (userId != -1) {
                // Create a session and store user information
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("username", username);

                // Redirect to the user profile page
                response.sendRedirect("user-profile.jsp");
            } else {
                // Redirect to the login page with an error message
                response.sendRedirect("Login.jsp?error=true");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Redirect to an error page
            response.sendRedirect("login-error.jsp");
        }
    }

    private int authenticateAndGetUserId(String username, String password) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String query = "SELECT id FROM Users WHERE username=? AND password=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? resultSet.getInt("id") : -1;
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }
}
