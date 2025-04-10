package lt.kauneta.edemocracy.quiz.controller;

import lt.kauneta.edemocracy.quiz.dto.*;
import lt.kauneta.edemocracy.quiz.model.QuizQuestion;
import lt.kauneta.edemocracy.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
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
        // TODO: Replace hardcoded userId with extracted one from JWT
        Long userId = 1L;
        return ResponseEntity.ok(quizService.createQuestion(dto, userId));
    }
}
