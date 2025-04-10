package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;

public class AnswerQuizDTO {
    private Long questionId;
    private QuizAnswerOption selectedAnswer;
    private int timeTakenSeconds;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public QuizAnswerOption getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(QuizAnswerOption selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public int getTimeTakenSeconds() {
		return timeTakenSeconds;
	}
	public void setTimeTakenSeconds(int timeTakenSeconds) {
		this.timeTakenSeconds = timeTakenSeconds;
	}
    
    
}

