package lt.kauneta.edemocracy.issue.presentation;

import lt.kauneta.edemocracy.issue.application.IssueService;
import lt.kauneta.edemocracy.issue.domain.Issue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody CreateIssueRequest request) {
        Issue issue = issueService.createIssue(request.title(), request.description(), request.district());
        return ResponseEntity.ok(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable UUID id) {
        Optional<Issue> issue = issueService.findById(id);
        return issue.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<List<Issue>> getIssuesByDistrict(@PathVariable String district) {
        return ResponseEntity.ok(issueService.findByDistrict(district));
    }

    @PostMapping("/{id}/relevant")
    public ResponseEntity<Void> markAsRelevant(@PathVariable UUID id, @RequestBody MarkRelevantRequest request) {
        issueService.markAsRelevant(id, request.userId());
        return ResponseEntity.ok().build();
    }

    public record CreateIssueRequest(String title, String description, String district) {}

    public record MarkRelevantRequest(UUID userId) {}
}
