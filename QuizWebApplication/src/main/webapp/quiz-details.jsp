<%@ page import="java.util.List" %>
<%@ page import="dk.QuizDAO" %> <!-- Replace 'your_package_name' with the actual package name -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f5f5f5;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button {
            background-color: #2ecc71;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>
    <h2>Quiz Details</h2>

    <%-- Display quiz details here --%>

    <form action="AddQuestionServlet" method="post">
        <label for="questionText">Question Text:</label>
        <input type="text" id="questionText" name="questionText" required><br>

        <label for="option1">Option 1:</label>
        <input type="text" id="option1" name="option1" required>
        <input type="radio" name="correctOption" value="1" required><br>

        <label for="option2">Option 2:</label>
        <input type="text" id="option2" name="option2" required>
        <input type="radio" name="correctOption" value="2" required><br>

        <label for="option3">Option 3:</label>
        <input type="text" id="option3" name="option3" required>
        <input type="radio" name="correctOption" value="3" required><br>

        <button type="submit">Add Question</button>
        
        <a href="quiz-list.jsp">Back to home</a>
    </form>
</body>
</html>
