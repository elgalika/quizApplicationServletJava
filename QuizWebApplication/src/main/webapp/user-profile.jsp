<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            box-sizing: border-box;
            display: flex;
            align-items: center;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        p {
            color: #555;
            margin-bottom: 10px;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            margin-right: 20px;
            margin-left:60px;
        }

        a {
            text-decoration: none;
            color: #fff;
            display: block;
            margin-bottom: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            text-align:center;
        }

        a:hover {
            background-color: #0056b3;
        }

        img {
            border-radius: 14px;
            max-width: 100%;
            height: auto;
            margin-left:150px;
            margin-top:70px;
        }
    </style>
</head>
<body>
<div class="button-container">
    <h2>HOME</h2>
    <%-- Display user information from the session --%>
    <p>Welcome, <%= session.getAttribute("username") %>!</p>

    <a href="update-profile.jsp">View/Update Profile</a>
    <a href="quiz-list-for-user.jsp">Quiz</a>
    <a href="quizHistory.jsp">Quiz History</a>
    <a href="logout.jsp">Logout</a>
</div> 
<div>  
    <img src="https://t3.ftcdn.net/jpg/03/45/97/36/360_F_345973621_sMifpCogXNoIDjmXlbLwx1QZA5ZmQVl8.jpg" alt="Profile Image">
</div> 
</body>
</html>
