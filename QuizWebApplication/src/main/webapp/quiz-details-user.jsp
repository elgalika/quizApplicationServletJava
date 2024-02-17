<%@ page import="dk.QuizDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dk.Questions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 20px;
        }

        h2 {
            color: #007BFF;
        }

        h3 {
            color: #28a745;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
    
<script>
    var timer;
    var timeRemaining = <%= request.getAttribute("quizDuration") %>; // Set initial time from the server

    function startTimer() {
        // Assuming <%= request.getAttribute("quizDuration") %> is in seconds
        timeRemaining = <%= request.getAttribute("quizDuration") %>;

        timer = setInterval(function() {
            document.getElementById("timer").innerText = formatTime(timeRemaining);
            timeRemaining--;

            if (timeRemaining < 0) {
                clearInterval(timer);
                alert("Time's up! Quiz not completed.");
                window.location.href = "quiz-list-for-user.jsp"; // Change this to the Quiz page URL
            }
        }, 1000); // Update every second (1000 milliseconds)
    }

    function resetTimer() {
        clearInterval(timer);
        timeRemaining = <%= request.getAttribute("quizDuration") %>; // Reset time to quiz duration
        startTimer();
    }

    function formatTime(seconds) {
        var minutes = Math.floor(seconds / 60);
        var remainingSeconds = seconds % 60;
        return pad(minutes) + ":" + pad(remainingSeconds);
    }

    function pad(value) {
        return value < 10 ? "0" + value : value;
    }

    // Start the timer when the page loads
    window.onload = function() {
        startTimer();
    };

    // Add an event listener to reset the timer when a radio button is clicked
    document.addEventListener('change', function(event) {
        if (event.target.type === 'radio') {
            resetTimer();
        }
    });
</script>

    
    
</head>
<body>
    <h2>Quiz Details</h2>
<div id="timer"></div>

    <%-- Retrieve quizId from the request parameters --%>
   <% 
    String quizIdParam = request.getParameter("quizId");
        
    if (quizIdParam != null && !quizIdParam.isEmpty()) {
        int quizId = Integer.parseInt(quizIdParam);
        List<Questions> questions = QuizDAO.getQuestionsForQuiz(quizId);
        int totalQuestions = questions.size();

        request.setAttribute("questions", questions);
        request.setAttribute("quizId", quizId);
        request.setAttribute("userId", session.getAttribute("userId"));
        request.setAttribute("quizDuration", QuizDAO.getQuizDuration(quizId));
        request.setAttribute("totalQuestions", totalQuestions);  // Define totalQuestions here
    %>

    <!-- Display quiz details -->
    <h3>Quiz Questions:</h3>
    <form action="SubmitQuizServlet?quizId=<%= quizId %>&userId=<%= session.getAttribute("userId") %>" method="post">
        <ul>
            <% 
                for (int i = 0; i < questions.size(); i++) {
                    Questions question = questions.get(i);
            %>
                <li id="question_<%= i %>" style="<%= i == 0 ? "display: block;" : "display: none;" %>">
                    <%= question.getQuestionText() %><br>
                    <input type="radio" name="question_<%= question.getId() %>" value="1"> <%= question.getOption1() %><br>
                    <input type="radio" name="question_<%= question.getId() %>" value="2"> <%= question.getOption2() %><br>
                    <input type="radio" name="question_<%= question.getId() %>" value="3"> <%= question.getOption3() %><br>
                </li>
            <%
                }
            %>
        </ul>
        <button type="button" onclick="showQuestion('prev')">Previous</button>
        <button type="button" onclick="showQuestion('next')">Next</button>
        <button type="submit">Submit Quiz</button>
    </form>

<%
    } else {
        out.println("Quiz ID not found in the request parameters.");
    }
%>

<!-- Other actions or links -->
<script>
    var currentQuestion = 0;
    var totalQuestions = <%= request.getAttribute("totalQuestions") %>;

    function showQuestion(direction) {
        var nextQuestion = currentQuestion;

        if (direction === 'prev') {
            nextQuestion = (currentQuestion - 1 + totalQuestions) % totalQuestions;
        } else if (direction === 'next') {
            nextQuestion = (currentQuestion + 1) % totalQuestions;
        }

        document.getElementById('question_' + currentQuestion).style.display = 'none';
        document.getElementById('question_' + nextQuestion).style.display = 'block';

        currentQuestion = nextQuestion;
    }
</script>
</body>
</html>
