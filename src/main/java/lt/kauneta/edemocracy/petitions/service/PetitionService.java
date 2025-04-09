package lt.kauneta.edemocracy.petitions.service;

import lt.kauneta.edemocracy.petitions.dto.PetitionRequestDTO;
import lt.kauneta.edemocracy.petitions.dto.PetitionResponseDTO;
import lt.kauneta.edemocracy.petitions.dto.PetitionUpdateDTO;
import lt.kauneta.edemocracy.petitions.model.Petition;
import lt.kauneta.edemocracy.petitions.model.PetitionCategory;
import lt.kauneta.edemocracy.petitions.model.PetitionStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PetitionService {
    private final Map<Long, Petition> petitionStore = new HashMap<>();
    private final AtomicLong petitionIdGenerator = new AtomicLong(1);

    public PetitionResponseDTO createPetition(PetitionRequestDTO request, Long authorId) {
        Long id = petitionIdGenerator.getAndIncrement();
        Petition petition = new Petition(id, request.getTitle(), request.getDescription(),
                request.getCategory(), PetitionStatus.PENDING_REVIEW, authorId);
        petitionStore.put(id, petition);
        return toDTO(petition);
    }

    public List<PetitionResponseDTO> getAllPetitions() {
        return petitionStore.values().stream()
                .sorted(Comparator.comparing(Petition::getCreatedAt).reversed())
                .map(this::toDTO)
                .toList();
    }

    public Optional<PetitionResponseDTO> getPetitionById(Long id) {
        return Optional.ofNullable(petitionStore.get(id)).map(this::toDTO);
    }

    public Optional<PetitionResponseDTO> updatePetition(Long id, Long authorId, PetitionUpdateDTO update) {
        Petition petition = petitionStore.get(id);
        if (petition == null || !petition.getAuthorId().equals(authorId)) return Optional.empty();
        if (petition.getStatus() != PetitionStatus.PENDING_REVIEW) return Optional.empty();

        petition.setTitle(update.getTitle());
        petition.setDescription(update.getDescription());
        petition.setCategory(update.getCategory());
        return Optional.of(toDTO(petition));
    }

    private PetitionResponseDTO toDTO(Petition petition) {
        return new PetitionResponseDTO(
                petition.getId(),
                petition.getTitle(),
                petition.getDescription(),
                petition.getCategory(),
                petition.getStatus(),
                petition.getAuthorId(),
                petition.getCreatedAt()
        );
    }
}