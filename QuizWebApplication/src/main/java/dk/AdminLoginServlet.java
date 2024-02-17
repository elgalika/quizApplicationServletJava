package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
	public class AdminLoginServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Retrieve admin credentials from the request
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Check if the credentials match the predefined admin credentials
	        if ("admin".equals(username) && "admin123".equals(password)) {
	            // Admin login successful, redirect to admin dashboard or another admin page
	            response.sendRedirect("quiz-list.jsp");
	        } else {
	            // Admin login failed, redirect back to the login page with an error message
	            response.sendRedirect("admin-login.jsp?error=true");
	        }
	    }
	
}
