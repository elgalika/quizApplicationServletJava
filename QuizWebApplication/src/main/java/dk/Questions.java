package dk;

public class Questions {
    private int id;
    private int quizId; // Foreign key referencing the Quizzes table
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private int correctOption;

    // Constructors (default and parameterized) can be added if needed

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public Questions() {
		super();
	}

	public Questions(int id, int quizId, String questionText, String option1, String option2, String option3,
			int correctOption) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.questionText = questionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.correctOption = correctOption;
	}

	public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }
}
