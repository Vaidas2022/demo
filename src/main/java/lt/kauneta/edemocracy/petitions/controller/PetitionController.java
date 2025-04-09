package lt.kauneta.edemocracy.petitions.controller;

import lt.kauneta.edemocracy.auth.model.User;
import lt.kauneta.edemocracy.petitions.dto.PetitionRequestDTO;
import lt.kauneta.edemocracy.petitions.dto.PetitionResponseDTO;
import lt.kauneta.edemocracy.petitions.service.PetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petitions")
public class PetitionController {

    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    // ✅ Sukūrimas (tik Councilor ir aukštesni)
    @PostMapping
    @PreAuthorize("hasRole('COUNCILOR')")
    public ResponseEntity<PetitionResponseDTO> createPetition(
            @RequestBody PetitionRequestDTO request,
            @AuthenticationPrincipal User currentUser
    ) {
        PetitionResponseDTO response = petitionService.createPetition(request, currentUser.getId());
        return ResponseEntity.ok(response);
    }

    // ✅ Gauti visas
    @GetMapping
    public ResponseEntity<List<PetitionResponseDTO>> getAllPetitions() {
        return ResponseEntity.ok(petitionService.getAllPetitions());
    }

    // ✅ Gauti vieną pagal ID
    @GetMapping("/{id}")
    public ResponseEntity<PetitionResponseDTO> getPetitionById(@PathVariable Long id) {
        return petitionService.getPetitionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
