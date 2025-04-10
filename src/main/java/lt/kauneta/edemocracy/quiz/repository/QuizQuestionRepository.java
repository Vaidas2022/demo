package lt.kauneta.edemocracy.quiz.repository;

import lt.kauneta.edemocracy.quiz.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    List<QuizQuestion> findByCategory(lt.kauneta.edemocracy.quiz.model.QuizCategory category);    
}
