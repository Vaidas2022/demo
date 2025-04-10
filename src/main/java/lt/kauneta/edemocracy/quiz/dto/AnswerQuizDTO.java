package lt.kauneta.edemocracy.quiz.dto;

import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;

public class AnswerQuizDTO {
    private Long questionId;
    private QuizAnswerOption selectedAnswer;
    private int timeTakenSeconds;
}

