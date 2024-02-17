<%@ page import="dk.Quizzes" %>
<%@ page import="java.util.List" %>
<%@ page import="dk.QuizDAO" %> <!-- Replace 'your_package_name' with the actual package name -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz List</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            background-color: #fff;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        a {
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }

        a:hover {
            color: #0056b3;
        }

        .action-links {
            text-align: center;
            margin-top: 20px;
        }

        .action-links a {
            display: block;
            margin-bottom: 10px;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }

        .action-links a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Quiz List</h2>

    <%-- Fetch and display the list of quizzes from the database --%>
    <ul>
        <% 
            List<Quizzes> quizzes = QuizDAO.getAllQuizzes();
            for (Quizzes quiz : quizzes) {
        %>
            <li>
                <a href="QuizDetailsServlet?quizId=<%= quiz.getId() %>">
                    <%= quiz.getTitle() %> - <%= quiz.getTopic() %>
                </a>
            </li>
        <%
            }
        %>
    </ul>

    <div class="action-links">
        <a href="add-quiz.jsp">Add Quiz</a>
        <a href="edit-quiz.jsp">Edit Quiz</a>
        <a href="delete-quiz.jsp">Delete Quiz</a>
    </div>
</body>
</html>
