package lt.kauneta.edemocracy.petition.dto;

import java.time.Instant;

import lt.kauneta.edemocracy.petition.model.PetitionCategory;
import lt.kauneta.edemocracy.petition.model.PetitionStatus;

public class PetitionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private PetitionCategory category;
    private lt.kauneta.edemocracy.petition.domain.PetitionStatus status;
    private Long authorId;
    private Instant createdAt;

    public PetitionResponseDTO(Long id, String title, String description, PetitionCategory category,
                                lt.kauneta.edemocracy.petition.domain.PetitionStatus status, Long authorId, Instant createdAt) {
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
    public lt.kauneta.edemocracy.petition.domain.PetitionStatus getStatus() { return status; }
    public Long getAuthorId() { return authorId; }
    public Instant getCreatedAt() { return createdAt; }
}