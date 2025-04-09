package lt.kauneta.edemocracy.petitions.model;

import java.time.Instant;

public class Petition {
    private Long id;
    private String title;
    private String description;
    private PetitionCategory category;
    private PetitionStatus status;
    private Long authorId;
    private Instant createdAt;
    private int signatureCount;

    public Petition(Long id, String title, String description, PetitionCategory category, PetitionStatus status, Long authorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = status;
        this.authorId = authorId;
        this.createdAt = Instant.now();
        this.signatureCount = 0;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public PetitionCategory getCategory() { return category; }
    public PetitionStatus getStatus() { return status; }
    public Long getAuthorId() { return authorId; }
    public Instant getCreatedAt() { return createdAt; }
    public int getSignatureCount() { return signatureCount; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(PetitionCategory category) { this.category = category; }
    public void incrementSignatureCount() { this.signatureCount++; }
}