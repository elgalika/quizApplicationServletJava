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
@WebServlet("/SubmitQuizServlet")
public class SubmitQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getUserIdFromSession(request);
        
        // Get quizId from request parameters
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        
        List<Questions> questions = QuizDAO.getQuestionsForQuiz(quizId);

        int totalQuestions = questions.size();
        int correctAnswers = 0;

        for (Questions question : questions) {
            String answerParam = "question_" + question.getId();
            int userAnswer = Integer.parseInt(request.getParameter(answerParam));

            if (userAnswer == question.getCorrectOption()) {
                correctAnswers++;
            }
        }

        // Calculate and save the user's score (you can save it in the database)
        double score = ((double) correctAnswers / totalQuestions) * 100;
        QuizDAO.saveQuizResult(userId, quizId, score);

        // You may want to store the score in the session for further use
        request.getSession().setAttribute("quizScore", score);

        // Redirect to a page to display the user's score
        response.sendRedirect("quiz-result.jsp");
    }


    private int getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Object userIdAttribute = session.getAttribute("userId");

            if (userIdAttribute != null) {
                System.out.println("userIdAttribute: " + userIdAttribute);
                System.out.println("userIdAttribute type: " + userIdAttribute.getClass().getName());

                if (userIdAttribute instanceof Integer) {
                    return ((Integer) userIdAttribute).intValue();
                } else {
                    System.out.println("userIdAttribute is not an instance of Integer");
                }
            }
        }

        // If the session is null or userIdAttribute is not present, handle it accordingly
        return -1;  // Default value, adjust as needed
    }

//    private int getUserIdFromRequest(HttpServletRequest request) {
//        String userIdParam = request.getParameter("userId");
//
//        if (userIdParam != null && !userIdParam.isEmpty()) {
//            try {
//                return Integer.parseInt(userIdParam);
//            } catch (NumberFormatException e) {
//                // Handle the case when userIdParam is not a valid integer
//                e.printStackTrace(); // Log or handle the exception as needed
//            }
//        }
//
//        // If something goes wrong or userIdParam is not present or not valid, return a default value
//        return -1;
//    }
//
//   
    }


