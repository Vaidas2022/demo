package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;

public class QuizResultDTO {
    private boolean correct;
    private QuizAnswerOption correctAnswer;
    private int timeTakenSeconds;
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
    
    
}
