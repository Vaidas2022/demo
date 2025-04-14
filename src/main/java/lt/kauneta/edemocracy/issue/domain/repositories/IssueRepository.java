package lt.kauneta.edemocracy.issue.domain.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.kauneta.edemocracy.issue.domain.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>  {
	Optional<Issue> findById(UUID id);

    List<Issue> findByDistrict(String district);

}
