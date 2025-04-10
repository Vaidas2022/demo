package lt.kauneta.edemocracy.quiz.service;

import lt.kauneta.edemocracy.auth.service.UserService;
import lt.kauneta.edemocracy.quiz.dto.AnswerQuizDTO;
import lt.kauneta.edemocracy.quiz.dto.CreateQuizQuestionDTO;
import lt.kauneta.edemocracy.quiz.dto.QuizQuestionDTO;
import lt.kauneta.edemocracy.quiz.dto.QuizResultDTO;
import lt.kauneta.edemocracy.quiz.model.*;
import lt.kauneta.edemocracy.quiz.repository.QuizQuestionRepository;
import lt.kauneta.edemocracy.quiz.repository.QuizUserProgressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizUserProgressRepository quizUserProgressRepository;
    private final UserService userService;

    public QuizService(QuizQuestionRepository quizQuestionRepository,
                       QuizUserProgressRepository quizUserProgressRepository,
                       UserService userService) {
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizUserProgressRepository = quizUserProgressRepository;
        this.userService = userService;
    }

    public QuizQuestionDTO getRandomQuestion() {
        Long userId = userService.getCurrentUserId();
        List<QuizQuestion> all = quizQuestionRepository.findAll();
        List<QuizQuestion> unseen = all.stream()
                .filter(q -> !quizUserProgressRepository.existsByUserIdAndQuestionId(userId, q.getId()))
                .toList();

        if (unseen.isEmpty()) {
            throw new RuntimeException("No new questions available.");
        }

        QuizQuestion question = unseen.get(new Random().nextInt(unseen.size()));
        return new QuizQuestionDTO(
                question.getId(),
                question.getQuestionText(),
                question.getCategory(),
                question.getTimeLimitSeconds()
        );
    }

    public QuizResultDTO submitAnswer(AnswerQuizDTO answerDTO) {
        Long userId = 1L;//userService.getCurrentUserId();
        QuizQuestion question = getQuestionOrThrow(answerDTO.getQuestionId());

        boolean correct = isAnswerCorrect(answerDTO, question);
        updateQuestionStats(question, correct, answerDTO.getSelectedAnswer());
        saveProgress(userId, question, answerDTO, correct);

        return buildResultDTO(answerDTO, question, correct);
    }

    public QuizQuestion createQuestion(CreateQuizQuestionDTO dto, Long userId) {
        QuizQuestion question = new QuizQuestion(
                dto.getQuestionText(),
                dto.getCategory(),
                dto.getCorrectAnswer(),
                dto.getTimeLimitSeconds(),
                userId,
                dto.getExplanation()
        );
        return quizQuestionRepository.save(question);
    }

    // --- Private helpers ---

    private QuizQuestion getQuestionOrThrow(Long id) {
        return quizQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    private boolean isAnswerCorrect(AnswerQuizDTO answer, QuizQuestion question) {
        return answer.getSelectedAnswer() == question.getCorrectAnswer();
    }

    private void updateQuestionStats(QuizQuestion question, boolean correct, QuizAnswerOption selected) {
        if (selected == null) {
            question.incrementSkippedCount();
        } else if (correct) {
            question.incrementCorrectCount();
        } else {
            question.incrementIncorrectCount();
        }
        quizQuestionRepository.save(question);
    }

    private void saveProgress(Long userId, QuizQuestion question, AnswerQuizDTO dto, boolean correct) {
        QuizUserProgress progress = new QuizUserProgress(
                userId,
                question.getId(),
                dto.getSelectedAnswer(),
                correct,
                dto.getSelectedAnswer() == null,
                dto.getTimeTakenSeconds(),
                LocalDateTime.now()
        );
        quizUserProgressRepository.save(progress);
    }

    private QuizResultDTO buildResultDTO(AnswerQuizDTO dto, QuizQuestion question, boolean correct) {
        return new QuizResultDTO(
                correct,
                question.getCorrectAnswer(),
                dto.getTimeTakenSeconds(),
                question.getExplanation()
        );
    }
}
