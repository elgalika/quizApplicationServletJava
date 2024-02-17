package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditQuizServlet")
public class EditQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        String title = request.getParameter("title");
        String topic = request.getParameter("topic");

        // Call a method to update the quiz in the database
        if (QuizDAO.editQuiz(quizId, title, topic)) {
            // Redirect to the quiz list with success message
            response.sendRedirect("quiz-list.jsp?success=true");
        } else {
            // Redirect to the edit quiz page with an error message
            response.sendRedirect("edit-quiz.jsp?error=true");
        }
    }
}
