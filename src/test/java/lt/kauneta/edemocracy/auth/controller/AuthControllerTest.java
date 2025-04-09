package lt.kauneta.edemocracy.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.kauneta.edemocracy.auth.dto.LoginResponseDTO;
import lt.kauneta.edemocracy.auth.service.AuthService;
import lt.kauneta.edemocracy.security.JwtAuthFilter;
import lt.kauneta.edemocracy.security.SecurityConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Login request returns token when credentials are valid")
    void loginWithValidCredentialsReturnsToken() throws Exception {
        Map<String, String> loginRequest = new HashMap<>();
        loginRequest.put("username", "demo");
        loginRequest.put("password", "password123");

        LoginResponseDTO mockResponse = new LoginResponseDTO("fake-jwt-token");

        Mockito.when(authService.authenticate(Mockito.any()))
                .thenReturn(mockResponse);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accessToken").value("fake-jwt-token"));
    }

    @Test
    @DisplayName("Login request returns 401 when credentials are invalid")
    void loginWithInvalidCredentialsReturns401() throws Exception {
        Map<String, String> loginRequest = new HashMap<>();
        loginRequest.put("username", "invalid");
        loginRequest.put("password", "wrong");

        Mockito.when(authService.authenticate(Mockito.any()))
                .thenThrow(new RuntimeException("Invalid credentials"));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isUnauthorized());
    }
}