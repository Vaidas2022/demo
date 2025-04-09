package lt.kauneta.edemocracy.petitions.model;

import java.time.Instant;

public class PetitionSignature {
    private Long petitionId;
    private Long userId;
    private Instant signedAt;

    public PetitionSignature(Long petitionId, Long userId) {
        this.petitionId = petitionId;
        this.userId = userId;
        this.signedAt = Instant.now();
    }

    public Long getPetitionId() { return petitionId; }
    public Long getUserId() { return userId; }
    public Instant getSignedAt() { return signedAt; }
}