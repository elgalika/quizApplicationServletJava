package dk;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId"); // Assuming the attribute name is "userId"

        // Retrieve user-specific information (e.g., quiz history) from the database
        // List<QuizResult> quizResults = QuizResultService.getQuizResultsForUser(userId);

        // Set the user ID and quiz results as request attributes
        request.setAttribute("userId", userId);
        // request.setAttribute("quizResults", quizResults);

        // Forward the request to the JSP page for the user profile
        request.getRequestDispatcher("user-profile.jsp").forward(request, response);
    }
}
