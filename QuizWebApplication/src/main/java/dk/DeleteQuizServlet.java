package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteQuizServlet")
public class DeleteQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        // Call a method to delete the quiz from the database
        if (QuizDAO.deleteQuiz(quizId)) {
            // Redirect to the quiz list with success message
            response.sendRedirect("quiz-list.jsp?success=true");
        } else {
            // Redirect to the delete quiz page with an error message
            response.sendRedirect("delete-quiz.jsp?error=true");
        }
    }
}

