<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="dk.Users" %>
<%@ page import="dk.QuizDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View/Update Profile</title>
    <style>
        body {
           font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    text-align: center;
    flex-direction: column;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 300px;
            width: 100%;
            text-align: center;
           
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button:hover {
            background-color: #45a049;
        }

        p {
            margin-top: 20px;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>

<div>
 <%-- Display User Information --%>
    <%
        int userId = (int) session.getAttribute("userId");
        Users user = QuizDAO.getUserById(userId);
    %>

    <h2>User Information</h2>
    <p>ID: <%= user.getId() %></p>
    <p>Username: <%= user.getUsername() %></p>
    <p>Email: <%= user.getEmail() %></p>
    </div>
    <br>
 <br> <br>
    <form class="f1" action="UpdateProfileServlet" method="post">
        <h2>Update Password</h2>
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        <button type="submit">Update</button>
    </form>
 <br> <br> <br> <br>
    <form class="f2" action="UpdateEmailServlet" method="post">
        <h2>Update Email</h2>
        <label for="newEmail">New Email:</label>
        <input type="email" id="newEmail" name="newEmail" required>
        <button type="submit">Update</button>
    </form>
 <br> <br> <br> <br>
    <p><a href="user-profile.jsp">Back to Profile</a></p>

    <br> <br> <br> <br>
</body>
</html>
