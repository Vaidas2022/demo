package lt.kauneta.edemocracy.petition.dto;

import lt.kauneta.edemocracy.petition.model.PetitionCategory;

public class PetitionRequestDTO {
    private String title;
    private String description;
    private PetitionCategory category;

    public PetitionRequestDTO() {}

    public PetitionRequestDTO(String title, String description, PetitionCategory category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public PetitionCategory getCategory() { return category; }
}
