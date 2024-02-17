package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizDetailsServlet")
public class QuizDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        // Store the quizId in the session
        HttpSession session = request.getSession();
        session.setAttribute("currentQuizId", quizId);

        // Redirect to the quiz details page
        response.sendRedirect("quiz-details.jsp");
    }
}
