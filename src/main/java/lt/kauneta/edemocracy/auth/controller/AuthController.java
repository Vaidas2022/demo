package lt.kauneta.edemocracy.auth.controller;

import lt.kauneta.edemocracy.auth.dto.*;
import lt.kauneta.edemocracy.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
