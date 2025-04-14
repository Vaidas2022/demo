package lt.kauneta.edemokratija.issue.application;

import lt.kauneta.edemokratija.issue.domain.Issue;
import lt.kauneta.edemokratija.issue.domain.repositories.IssueRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue createIssue(String title, String description, String district) {
        Issue issue = new Issue(UUID.randomUUID(), title, description, district);
        issueRepository.save(issue);
        return issue;
    }

    public Optional<Issue> findById(UUID id) {
        return issueRepository.findById(id);
    }

    public List<Issue> findByDistrict(String district) {
        return issueRepository.findByDistrict(district);
    }

    public void markAsRelevant(UUID issueId, UUID userId) {
        Optional<Issue> issueOpt = issueRepository.findById(issueId);
        if (issueOpt.isPresent()) {
            Issue issue = issueOpt.get();
            issue.markAsRelevant(userId);
            issueRepository.save(issue);
        } else {
            throw new IllegalArgumentException("Issue not found: " + issueId);
        }
    }
}
