<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Result</title>
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

        p {
            font-size: 24px;
            color: #28a745;
        }

        a {
            display: inline-block;
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Quiz Result</h2>

    <%-- Retrieve user's score from the session --%>
    <% 
        double quizScore = (double) session.getAttribute("quizScore");
        DecimalFormat df = new DecimalFormat("#.##");
    %>

    <p>Your score: <%= df.format(quizScore) %>%</p>

    <a href="user-profile.jsp">Home</a>
 <!--<a href="javascript:history.back()">Home</a>
    Other actions or links -->
</body>
</html>
