package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizCategory;

public class QuizQuestionDTO {
    private Long id;
    private String questionText;
    private QuizCategory category;
    private int timeLimitSeconds;


    

	public QuizQuestionDTO(Long id, String questionText, QuizCategory category, int timeLimitSeconds) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.category = category;
		this.timeLimitSeconds = timeLimitSeconds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public QuizCategory getCategory() {
		return category;
	}

	public void setCategory(QuizCategory category) {
		this.category = category;
	}

	public int getTimeLimitSeconds() {
		return timeLimitSeconds;
	}

	public void setTimeLimitSeconds(int timeLimitSeconds) {
		this.timeLimitSeconds = timeLimitSeconds;
	}
   
    
}
