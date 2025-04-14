package lt.kauneta.edemocracy.petition.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lt.kauneta.edemocracy.petition.model.PetitionCategory;

public class Petition {

    private final UUID id;
    private final UUID issueId;
    private final LocalDateTime createdAt;
    private LocalDateTime submittedAt;
    private PetitionStatus status;
    private final Set<UUID> supporterIds;

    private static final int MINIMUM_SUPPORTERS = 10;

    public Petition(UUID id, UUID issueId) {
        this.id = id;
        this.issueId = issueId;
        this.createdAt = LocalDateTime.now();
        this.supporterIds = new HashSet<>();
        this.status = PetitionStatus.DRAFT;
    }

    public Petition(UUID id, String title, String description, PetitionCategory category, PetitionStatus pendingReview,
			Long authorId) {
				this.id = id;
				this.issueId = null;
				this.createdAt = null;
				this.supporterIds = null;
	}

	public UUID getId() {
        return id;
    }

    public UUID getIssueId() {
        return issueId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public PetitionStatus getStatus() {
        return status;
    }

    public Set<UUID> getSupporterIds() {
        return supporterIds;
    }

    public void sign(UUID userId) {
        if (status != PetitionStatus.DRAFT && status != PetitionStatus.READY_FOR_SUBMISSION) {
            throw new IllegalStateException("Cannot sign petition in current status: " + status);
        }
        if (!supporterIds.add(userId)) {
            throw new IllegalArgumentException("User already signed this petition.");
        }
        if (supporterIds.size() >= MINIMUM_SUPPORTERS) {
            status = PetitionStatus.READY_FOR_SUBMISSION;
        }
    }

    public void submit() {
        if (status != PetitionStatus.READY_FOR_SUBMISSION) {
            throw new IllegalStateException("Petition is not ready for submission.");
        }
        this.submittedAt = LocalDateTime.now();
        this.status = PetitionStatus.SUBMITTED;
    }

    public boolean isReady() {
        return status == PetitionStatus.READY_FOR_SUBMISSION;
    }

    public void escalate() {
        if (status != PetitionStatus.SUBMITTED) {
            throw new IllegalStateException("Can only escalate submitted petitions.");
        }
        this.status = PetitionStatus.ESCALATED;
    }

    public void close() {
        this.status = PetitionStatus.CLOSED;
    }
}
