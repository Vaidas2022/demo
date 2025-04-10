package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;
import lt.kauneta.edemocracy.quiz.model.QuizCategory;

public class CreateQuizQuestionDTO {
    private String questionText;
    private QuizCategory category;
    private QuizAnswerOption correctAnswer;
    private int timeLimitSeconds;
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
	public QuizAnswerOption getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(QuizAnswerOption correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getTimeLimitSeconds() {
		return timeLimitSeconds;
	}
	public void setTimeLimitSeconds(int timeLimitSeconds) {
		this.timeLimitSeconds = timeLimitSeconds;
	}
    
    
}