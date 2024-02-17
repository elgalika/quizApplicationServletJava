package dk;

import java.sql.Timestamp;

public class QuizResult {
    private int userId;
    private int quizId;
    private String quizTitle;
    private double score;
    private Timestamp timestamp;

    public QuizResult(int userId, int quizId, String quizTitle, double score, Timestamp timestamp) {
        this.userId = userId;
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.score = score;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
