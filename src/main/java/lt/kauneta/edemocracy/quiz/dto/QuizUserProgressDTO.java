package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;
import java.time.LocalDateTime;

public class QuizUserProgressDTO {
    private Long questionId;
    private QuizAnswerOption selectedAnswer;
    private boolean correct;
    private boolean skipped;
    private int timeTakenSeconds;
    private LocalDateTime answeredAt;

    public QuizUserProgressDTO() {}

    public QuizUserProgressDTO(Long questionId, QuizAnswerOption selectedAnswer, boolean correct,
                                boolean skipped, int timeTakenSeconds, LocalDateTime answeredAt) {
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
        this.correct = correct;
        this.skipped = skipped;
        this.timeTakenSeconds = timeTakenSeconds;
        this.answeredAt = answeredAt;
    }

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

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public boolean isSkipped() {
		return skipped;
	}

	public void setSkipped(boolean skipped) {
		this.skipped = skipped;
	}

	public int getTimeTakenSeconds() {
		return timeTakenSeconds;
	}

	public void setTimeTakenSeconds(int timeTakenSeconds) {
		this.timeTakenSeconds = timeTakenSeconds;
	}

	public LocalDateTime getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(LocalDateTime answeredAt) {
		this.answeredAt = answeredAt;
	}

    
}