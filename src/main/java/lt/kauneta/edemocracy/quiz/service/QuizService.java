package lt.kauneta.edemocracy.quiz.service;

import lt.kauneta.edemocracy.auth.service.UserService;
import lt.kauneta.edemocracy.quiz.dto.*;
import lt.kauneta.edemocracy.quiz.model.QuizAnswerOption;
import lt.kauneta.edemocracy.quiz.model.QuizQuestion;
import lt.kauneta.edemocracy.quiz.model.QuizUserProgress;
import lt.kauneta.edemocracy.quiz.repository.QuizQuestionRepository;
import lt.kauneta.edemocracy.quiz.repository.QuizUserProgressRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    private final QuizQuestionRepository questionRepository;
    private final Random random = new Random();
	private final QuizUserProgressRepository quizUserProgressRepository;
	private final UserService userService;

    public QuizService(QuizQuestionRepository questionRepository, QuizUserProgressRepository quizUserProgressRepository, UserService userService) {
        this.questionRepository = questionRepository;
		this.quizUserProgressRepository = quizUserProgressRepository;
		this.userService = userService;
        
    }

    public QuizQuestionDTO getRandomQuestion() {
        List<QuizQuestion> all = questionRepository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("No questions available");
        }

        QuizQuestion question = all.get(random.nextInt(all.size()));

        return new QuizQuestionDTO(
                question.getId(),
                question.getQuestionText(),
                question.getCategory(),
                question.getTimeLimitSeconds()
        );
    }

    public QuizResultDTO submitAnswer(AnswerQuizDTO answerDTO) {
        Optional<QuizQuestion> optional = questionRepository.findById(answerDTO.getQuestionId());
        if (optional.isEmpty()) {
            throw new RuntimeException("Question not found");
        }

        QuizQuestion question = optional.get();

        boolean correct = answerDTO.getSelectedAnswer() == question.getCorrectAnswer();

        updateQuestionStats(question, answerDTO.getSelectedAnswer(), correct);
        
        QuizUserProgress progress = new QuizUserProgress(
        		userService.getCurrentUserId(), // ← You must fetch this from JWT or pass explicitly
        	    question.getId(),
        	    answerDTO.getSelectedAnswer(),
        	    correct,
        	    answerDTO.getSelectedAnswer() == null,
        	    answerDTO.getTimeTakenSeconds(),
        	    LocalDateTime.now()
        	);
        quizUserProgressRepository.save(progress);

        questionRepository.save(question);

        return new QuizResultDTO(
                correct,
                question.getCorrectAnswer(),
                answerDTO.getTimeTakenSeconds(),
                question.getExplanation()
        );
    }

    private void updateQuestionStats(QuizQuestion question, QuizAnswerOption selectedAnswer, boolean correct) {
        if (selectedAnswer == QuizAnswerOption.KITAS) {
            question.setSkippedCount(question.getSkippedCount() + 1);
        } else if (correct) {
            question.setCorrectCount(question.getCorrectCount() + 1);
        } else {
            question.setIncorrectCount(question.getIncorrectCount() + 1);
        }
    }

    public QuizQuestion createQuestion(CreateQuizQuestionDTO dto, Long userId) {
        QuizQuestion question = new QuizQuestion();
        question.setQuestionText(dto.getQuestionText());
        question.setCategory(dto.getCategory());
        question.setCorrectAnswer(dto.getCorrectAnswer());
        question.setTimeLimitSeconds(dto.getTimeLimitSeconds());
        question.setCreatedByUserId(userId);

        return questionRepository.save(question);
    }
}
