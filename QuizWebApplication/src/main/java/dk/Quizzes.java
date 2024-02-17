package dk;
public class Quizzes {
    private int id;
    private String title;
    private String topic;

    // Constructors (default and parameterized) can be added if needed

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public Quizzes() {
		super();
	}

	public Quizzes(int id, String title, String topic) {
		super();
		this.id = id;
		this.title = title;
		this.topic = topic;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
