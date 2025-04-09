package lt.kauneta.edemocracy.petitions.controller;

import lt.kauneta.edemocracy.petitions.dto.PetitionRequestDTO;
import lt.kauneta.edemocracy.petitions.service.PetitionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PetitionController.class)
class PetitionControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private PetitionService petitionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "councilor", roles = {"COUNCILOR"})
    @DisplayName("Sukuria peticiją su COUNCILOR role")
    void createPetition_asCouncilor_returnsOk() throws Exception {
        PetitionRequestDTO request = new PetitionRequestDTO("Test title", "Test description", null);

        mockMvc.perform(post("/api/petitions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "guest", roles = {"OBSERVER"})
    @DisplayName("Nepavyksta sukurti peticijos kaip OBSERVER")
    void createPetition_asObserver_returnsForbidden() throws Exception {
        PetitionRequestDTO request = new PetitionRequestDTO("Test", "Desc", null);

        mockMvc.perform(post("/api/petitions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", roles = {"CITIZEN"})
    @DisplayName("Pasirašo peticiją kaip CITIZEN")
    void signPetition_asCitizen_returnsOkOrConflict() throws Exception {
        Mockito.when(petitionService.signPetition(1L, 1L)).thenReturn(true);

        mockMvc.perform(post("/api/petitions/1/sign"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "anon", roles = {"OBSERVER"})
    @DisplayName("Negali pasirašyti peticijos kaip OBSERVER")
    void signPetition_asObserver_returnsForbidden() throws Exception {
        mockMvc.perform(post("/api/petitions/1/sign"))
                .andExpect(status().isForbidden());
    }
}