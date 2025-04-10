package lt.kauneta.edemocracy.quiz.repository;

import lt.kauneta.edemocracy.quiz.model.QuizUserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizUserProgressRepository extends JpaRepository<QuizUserProgress, Long> {
    List<QuizUserProgress> findByUserId(Long userId);
    boolean existsByUserIdAndQuestionId(Long userId, Long questionId);
}