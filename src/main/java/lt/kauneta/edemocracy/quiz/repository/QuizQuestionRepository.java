package lt.kauneta.edemocracy.quiz.repository;

import lt.kauneta.edemocracy.quiz.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    List<QuizQuestion> findByCategory(lt.kauneta.edemocracy.quiz.model.QuizCategory category);  
    
    @Query("SELECT q FROM QuizQuestion q WHERE q.id NOT IN (SELECT p.questionId FROM QuizUserProgress p WHERE p.userId = :userId)")
    List<QuizQuestion> findUnansweredByUserId(@Param("userId") Long userId);

}
