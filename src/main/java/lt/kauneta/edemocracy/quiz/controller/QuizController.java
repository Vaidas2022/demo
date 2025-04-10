package lt.kauneta.edemocracy.quiz.controller;

import lt.kauneta.edemocracy.auth.model.User;
import lt.kauneta.edemocracy.auth.repositories.UserRepository;
import lt.kauneta.edemocracy.quiz.dto.*;
import lt.kauneta.edemocracy.quiz.model.QuizQuestion;
import lt.kauneta.edemocracy.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;
    private final UserRepository userRepository;

    public QuizController(QuizService quizService, UserRepository userRepository) {
        this.quizService = quizService;
        this.userRepository = userRepository;
    }

    @GetMapping("/question")
    public ResponseEntity<QuizQuestionDTO> getRandomQuestion() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    @PostMapping("/answer")
    public ResponseEntity<QuizResultDTO> submitAnswer(@RequestBody AnswerQuizDTO answerDTO) {
        return ResponseEntity.ok(quizService.submitAnswer(answerDTO));
    }

    @PostMapping("/create")
    public ResponseEntity<QuizQuestion> createQuestion(@RequestBody CreateQuizQuestionDTO dto) {
        Long userId = getCurrentUserId();
        return ResponseEntity.ok(quizService.createQuestion(dto, userId));
    }

    private Long getCurrentUserId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .map(User::getId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
