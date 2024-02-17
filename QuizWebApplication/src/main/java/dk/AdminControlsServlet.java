package dk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminControlsServlet")
public class AdminControlsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            response.sendRedirect("add-quiz.jsp");
        } else if ("edit".equals(action)) {
            response.sendRedirect("edit-quiz.jsp");
        } else if ("delete".equals(action)) {
            response.sendRedirect("delete-quiz.jsp");
        } else {
            response.sendRedirect("quiz-list.jsp");
        }
    }
}