package lt.kauneta.edemocracy.issue.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Issue {

    private final UUID id;
    private String title;
    private String description;
    private String district;
    private IssueStatus status;
    private final Set<UUID> supporters;

    public Issue(UUID id, String title, String description, String district) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.district = district;
        this.status = IssueStatus.SUGGESTED;
        this.supporters = new HashSet<>();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDistrict() {
        return district;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public Set<UUID> getSupporters() {
        return supporters;
    }

    public void markAsRelevant(UUID userId) {
        this.supporters.add(userId);
        // Domain Event galima generuoti čia vėliau
        if (supporters.size() >= 10) {
            this.status = IssueStatus.READY_FOR_PETITION;
        }
    }

    public boolean isReadyForPetition() {
        return this.status == IssueStatus.READY_FOR_PETITION;
    }
}
