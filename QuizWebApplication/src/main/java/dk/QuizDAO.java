package dk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class QuizDAO {
	
	
	 // Existing methods...

    public static List<Quizzes> getAllQuizzes() {
        List<Quizzes> quizzes = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "SELECT * FROM Quizzes";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Quizzes quiz = new Quizzes();
                    quiz.setId(resultSet.getInt("id"));
                    quiz.setTitle(resultSet.getString("title"));
                    quiz.setTopic(resultSet.getString("topic"));
                    quizzes.add(quiz);
                }
            }
            DatabaseManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    // Existing methods...
    // Existing methods...

//    public static boolean addQuiz(String title, String topic) {
//        try {
//            Connection connection = DatabaseManager.getConnection();
//            String query = "INSERT INTO Quizzes (title, topic) VALUES (?, ?)";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, title);
//                preparedStatement.setString(2, topic);
//                int rowsAffected = preparedStatement.executeUpdate();
//                return rowsAffected > 0;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    
    public static boolean editQuiz(int quizId, String title, String topic) {
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "UPDATE Quizzes SET title=?, topic=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, topic);
                preparedStatement.setInt(3, quizId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean deleteQuiz(int quizId) {
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "DELETE FROM Quizzes WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, quizId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public static boolean addQuestion(int quizId, String questionText, String option1, String option2, String option3, int correctOption) {
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "INSERT INTO Questions (quiz_id, question_text, option1, option2, option3, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, quizId);
                preparedStatement.setString(2, questionText);
                preparedStatement.setString(3, option1);
                preparedStatement.setString(4, option2);
                preparedStatement.setString(5, option3);
                preparedStatement.setInt(6, correctOption);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    
    
    
    public static Quizzes getQuizById(int quizId) {
        Quizzes quiz = null;
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "SELECT * FROM Quizzes WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, quizId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    quiz = new Quizzes();
                    quiz.setId(resultSet.getInt("id"));
                    quiz.setTitle(resultSet.getString("title"));
                    quiz.setTopic(resultSet.getString("topic"));
                }
            }
            DatabaseManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    public static List<Questions> getQuestionsForQuiz(int quizId) {
        List<Questions> questions = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "SELECT * FROM Questions WHERE quiz_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, quizId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Questions question = new Questions();
                    question.setId(resultSet.getInt("id"));
                    question.setQuestionText(resultSet.getString("question_text"));
                    question.setOption1(resultSet.getString("option1"));
                    question.setOption2(resultSet.getString("option2"));
                    question.setOption3(resultSet.getString("option3"));
                    question.setCorrectOption(resultSet.getInt("correct_option"));
                    questions.add(question);
                }
            }
            DatabaseManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static boolean saveQuizResult(int userId, int quizId, double score) {
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "INSERT INTO Results (user_id, quiz_id, score, timestamp) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, quizId);
                preparedStatement.setDouble(3, score);

                // Set the current timestamp
                Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
                preparedStatement.setTimestamp(4, currentTimestamp);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static List<QuizResult> getQuizHistory(int userId) {
        List<QuizResult> quizHistory = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT r.quiz_id, q.title, r.score, r.timestamp " +
                           "FROM results r " +
                           "JOIN quizzes q ON r.quiz_id = q.id " +
                           "WHERE r.user_id = ? " +
                           "ORDER BY r.timestamp DESC";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int quizId = resultSet.getInt("quiz_id");
                        String title = resultSet.getString("title");
                        double score = resultSet.getDouble("score");
                        Timestamp timestamp = resultSet.getTimestamp("timestamp");

                        QuizResult result = new QuizResult(userId, quizId, title, score, timestamp);
                        quizHistory.add(result);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return quizHistory;
    }

    
    
    public static Users getUserById(int userId) throws SQLException {
        Users user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseManager.getConnection();
            String query = "SELECT * FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
        } finally {
            // Close resources
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return user;
    }

    // Utility method to close ResultSet, PreparedStatement, and Connection
    private static void close(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
    }
    


    
    public static int getQuizDuration(int quizId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int quizDuration = 0;

        try {
            connection = DatabaseManager.getConnection();

            // Updated SQL query with uppercase column and table names
            String query = "SELECT DURATION FROM QUIZZES WHERE ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quizId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quizDuration = resultSet.getInt("DURATION");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions as needed
        } finally {
            // Close resources
            DatabaseManager.closeResultSet(resultSet);
            DatabaseManager.closePreparedStatement(preparedStatement);
            DatabaseManager.closeConnection(connection);
        }

        return quizDuration;
    }
    
    
    
    public static boolean addQuiz(String title, String topic, int duration) {
        try {
            Connection connection = DatabaseManager.getConnection();
            String query = "INSERT INTO Quizzes (title, topic, duration) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, topic);
                preparedStatement.setInt(3, duration);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
