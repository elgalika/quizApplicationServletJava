<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="dk.QuizResult" %>
<%@ page import="dk.QuizDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz History</title>
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

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Quiz History</h2>

    <%-- Fetch and display the quiz history from the database --%>
    <table>
        <tr>
            <th>Quiz ID</th>
            <th>Title</th>
            <th>Points</th>
            <th>Timestamp</th>
        </tr>
        <% 
            List<QuizResult> quizHistory = QuizDAO.getQuizHistory((int) session.getAttribute("userId"));
            for (QuizResult result : quizHistory) {
        %>
            <tr>
                <td><%= result.getQuizId() %></td>
                <td><%= result.getQuizTitle() %></td>
                <td><%= result.getScore() %></td>
                <td><%= result.getTimestamp() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
