package lt.kauneta.edemocracy.quiz.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class QuizUserProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long questionId;

    @Enumerated(EnumType.STRING)
    private QuizAnswerOption selectedAnswer;

    private boolean correct;
    private boolean skipped;
    private int timeTakenSeconds;
    private LocalDateTime answeredAt;

    public QuizUserProgress() {}

    public QuizUserProgress(Long userId, Long questionId, QuizAnswerOption selectedAnswer,
                             boolean correct, boolean skipped, int timeTakenSeconds, LocalDateTime answeredAt) {
        this.userId = userId;
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
        this.correct = correct;
        this.skipped = skipped;
        this.timeTakenSeconds = timeTakenSeconds;
        this.answeredAt = answeredAt;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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