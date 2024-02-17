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
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user information from the session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        try {
            // Retrieve user information from the database
            UserProfile userProfile = getUserProfile(username);

            // Set user information as request attribute
            request.setAttribute("userProfile", userProfile);

            // Forward the request to the view-profile.jsp page
            request.getRequestDispatcher("view-profile.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Redirect to an error page
            response.sendRedirect("user-profile.jsp");
        }
    }

    private UserProfile getUserProfile(String username) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String query = "SELECT id, email, password FROM Users WHERE username=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new UserProfile(id, username, email, password);
            } else {
                return null; // User not found
            }
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }

    // Other methods...
}
