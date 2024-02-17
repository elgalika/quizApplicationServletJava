package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve question details from the form
        String questionText = request.getParameter("questionText");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        int correctOption = Integer.parseInt(request.getParameter("correctOption"));

        // Retrieve the current quizId from the session
        HttpSession session = request.getSession();
        int quizId = (int) session.getAttribute("currentQuizId");

        // Call a method to add the question to the database
        if (QuizDAO.addQuestion(quizId, questionText, option1, option2, option3, correctOption)) {
            // Redirect to the quiz details page with success message
            response.sendRedirect("quiz-details.jsp?success=true");
        } else {
            // Redirect to the quiz details page with an error message
            response.sendRedirect("quiz-details.jsp?error=true");
        }
    }
}