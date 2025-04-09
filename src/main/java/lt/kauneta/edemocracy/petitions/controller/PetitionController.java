package lt.kauneta.edemocracy.petitions.controller;

import lt.kauneta.edemocracy.auth.model.User;
import lt.kauneta.edemocracy.petitions.dto.PetitionRequestDTO;
import lt.kauneta.edemocracy.petitions.dto.PetitionResponseDTO;
import lt.kauneta.edemocracy.petitions.dto.PetitionUpdateDTO;
import lt.kauneta.edemocracy.petitions.service.PetitionService;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @PreAuthorize("hasRole('COUNCILOR')")
    public ResponseEntity<PetitionResponseDTO> createPetition(@RequestBody PetitionRequestDTO request,
                                                              @AuthenticationPrincipal User currentUser) {
        PetitionResponseDTO response = petitionService.createPetition(request, currentUser.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PetitionResponseDTO>> getAllPetitions() {
        return ResponseEntity.ok(petitionService.getAllPetitions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetitionResponseDTO> getPetitionById(@PathVariable Long id) {
        return petitionService.getPetitionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('COUNCILOR')")
    public ResponseEntity<PetitionResponseDTO> updatePetition(@PathVariable Long id,
                                                              @RequestBody PetitionUpdateDTO update,
                                                              @AuthenticationPrincipal User currentUser) {
        return petitionService.updatePetition(id, currentUser.getId(), update)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }

    @PostMapping("/{id}/sign")
    @PreAuthorize("hasAnyRole('CITIZEN','FACT_CHECKER','COUNCILOR','WIZARD')")
    public ResponseEntity<String> signPetition(@PathVariable Long id,
                                               @AuthenticationPrincipal User currentUser) {
        boolean success = petitionService.signPetition(id, currentUser.getId());
        return success
                ? ResponseEntity.ok("Signed successfully.")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("Already signed or petition not found.");
    }
}

