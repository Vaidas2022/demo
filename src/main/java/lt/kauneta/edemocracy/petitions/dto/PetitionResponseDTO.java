package lt.kauneta.edemocracy.petitions.dto;

import lt.kauneta.edemocracy.petitions.model.PetitionCategory;
import lt.kauneta.edemocracy.petitions.model.PetitionStatus;

import java.time.Instant;

public class PetitionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private PetitionCategory category;
    private PetitionStatus status;
    private Long authorId;
    private Instant createdAt;

    public PetitionResponseDTO(Long id, String title, String description, PetitionCategory category,
                                PetitionStatus status, Long authorId, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = status;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public PetitionCategory getCategory() { return category; }
    public PetitionStatus getStatus() { return status; }
    public Long getAuthorId() { return authorId; }
    public Instant getCreatedAt() { return createdAt; }
}
