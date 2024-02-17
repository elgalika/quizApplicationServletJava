package dk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizDetailsServletForUser")
public class QuizDetailsServletForUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

 // Inside QuizDetailsServletForUser.java
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            int quizId = Integer.parseInt(request.getParameter("quizId"));

            // Retrieve questions and quiz duration for the selected quiz
            List<Questions> questions = QuizDAO.getQuestionsForQuiz(quizId);
            int quizDuration = QuizDAO.getQuizDuration(quizId); // Assuming you have a method to get quiz duration

            // Set the questions, quizId, userId, and quizDuration in the request attributes
            request.setAttribute("questions", questions);
            request.setAttribute("quizId", quizId);
            request.setAttribute("userId", userId);
            request.setAttribute("quizDuration", quizDuration);

            // Forward the request to the quiz-details-user.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("quiz-details-user.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle the case where "userId" is not present in the session
            response.sendRedirect("Login.jsp"); // or wherever you want to redirect
        }
    }
}