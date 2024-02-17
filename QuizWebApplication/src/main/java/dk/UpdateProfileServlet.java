package dk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve new password and email from the form
        String newPassword = request.getParameter("newPassword");
    

        try {
            // Retrieve user information from the session
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // Update user profile in the database
            Connection connection = DatabaseManager.getConnection();
            String query = "UPDATE Users SET password=? WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, username);
                preparedStatement.executeUpdate();
            }
            DatabaseManager.closeConnection(connection);

            // Redirect to the user profile page
            response.sendRedirect("user-profile.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Redirect to an error page
            response.sendRedirect("update-profile-error.jsp");
        }
    }
}
