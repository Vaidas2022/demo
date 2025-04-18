package lt.kauneta.edemocracy.quiz.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String questionText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizAnswerOption correctAnswer;

    @Column(nullable = false)
    private int timeLimitSeconds = 10;
    
    @Column(length = 2000)
    private String explanation;

    private int correctCount = 0;
    private int incorrectCount = 0;
    private int skippedCount = 0;

    private Integer difficultyScore; 

    private Long createdByUserId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public QuizQuestion() {}

	public QuizQuestion(Long id, String questionText, QuizCategory category, QuizAnswerOption correctAnswer,
			int timeLimitSeconds, String explanation, int correctCount, int incorrectCount, int skippedCount,
			Integer difficultyScore, Long createdByUserId) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.category = category;
		this.correctAnswer = correctAnswer;
		this.timeLimitSeconds = timeLimitSeconds;
		this.explanation = explanation;
		this.correctCount = correctCount;
		this.incorrectCount = incorrectCount;
		this.skippedCount = skippedCount;
		this.difficultyScore = difficultyScore;
		this.createdByUserId = createdByUserId;
		this.createdAt = LocalDateTime.now();
	}

	public QuizQuestion(
						String questionText, 
						QuizCategory category, 
						QuizAnswerOption correctAnswer,
						int timeLimitSeconds, 
						Long createdByUserId, 
						String explanation
						) {
		super();
		this.questionText = questionText;
		this.category = category;
		this.correctAnswer = correctAnswer;
		this.timeLimitSeconds = timeLimitSeconds;
		this.explanation = explanation;

		this.createdByUserId = createdByUserId;
		this.createdAt = LocalDateTime.now();
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

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public int getIncorrectCount() {
		return incorrectCount;
	}

	public void setIncorrectCount(int incorrectCount) {
		this.incorrectCount = incorrectCount;
	}

	public int getSkippedCount() {
		return skippedCount;
	}

	public void setSkippedCount(int skippedCount) {
		this.skippedCount = skippedCount;
	}

	public Integer getDifficultyScore() {
		return difficultyScore;
	}

	public void setDifficultyScore(Integer difficultyScore) {
		this.difficultyScore = difficultyScore;
	}

	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void incrementSkippedCount() {
		skippedCount++;
		
	}

	public void incrementCorrectCount() {
		correctCount++;
		
	}

	public void incrementIncorrectCount() {
		incorrectCount++;
		
	}
    
	
    
}
