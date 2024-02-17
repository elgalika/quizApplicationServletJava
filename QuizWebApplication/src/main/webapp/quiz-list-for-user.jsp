<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="dk.Quizzes" %>
<%@ page import="dk.QuizDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            margin: 20px;
        }

        h2 {
            color: #007BFF;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        a {
            display: block;
            background-color: #007BFF;
            color: #fff;
            padding: 10px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
            margin-left:200px;
              margin-right:200px;
        }

        a:hover {
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
                <a href="QuizDetailsServletForUser?quizId=<%= quiz.getId() %>">
                    <%= quiz.getTitle() %> - <%= quiz.getTopic() %>
                </a>
            </li>
        <%
            }
        %>
    </ul>
</body>
</html>
