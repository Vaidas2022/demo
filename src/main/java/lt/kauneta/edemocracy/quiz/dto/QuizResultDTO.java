package lt.kauneta.edemocracy.quiz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;

public class QuizResultDTO {
    private boolean correct;
    private QuizAnswerOption correctAnswer;
    private int timeTakenSeconds;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String explanation;



	public QuizResultDTO(boolean correct, QuizAnswerOption correctAnswer, int timeTakenSeconds, String explanation) {
		super();
		this.correct = correct;
		this.correctAnswer = correctAnswer;
		this.timeTakenSeconds = timeTakenSeconds;
		this.explanation = explanation;
	}




	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public QuizAnswerOption getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(QuizAnswerOption correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getTimeTakenSeconds() {
		return timeTakenSeconds;
	}
	public void setTimeTakenSeconds(int timeTakenSeconds) {
		this.timeTakenSeconds = timeTakenSeconds;
	}




	public String getExplanation() {
		return explanation;
	}




	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
    
    
}
