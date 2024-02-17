package dk;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddQuizServlet")
public class AddQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String topic = request.getParameter("topic");
        int duration = Integer.parseInt(request.getParameter("duration")); // Retrieve the duration

        // Call a method to add the quiz to the database
        if (QuizDAO.addQuiz(title, topic, duration)) { // Pass duration to addQuiz method
            // Redirect to the quiz list with success message
            response.sendRedirect("quiz-list.jsp?success=true");
        } else {
            // Redirect to the add quiz page with an error message
            response.sendRedirect("add-quiz.jsp?error=true");
        }
    }
}
