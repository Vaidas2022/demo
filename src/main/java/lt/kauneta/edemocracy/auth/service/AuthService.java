package lt.kauneta.edemocracy.auth.service;

import lt.kauneta.edemocracy.auth.dto.*;
import lt.kauneta.edemocracy.auth.model.User;
import lt.kauneta.edemocracy.auth.model.UserRole;
import lt.kauneta.edemocracy.auth.repositories.UserRepository;
import lt.kauneta.edemocracy.security.JwtUtils;

import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

	private final UserService userService;
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AtomicLong userIdGenerator = new AtomicLong(3L);

    public AuthService(
    		UserService userService, 
    		PasswordEncoder passwordEncoder, 
    		JwtUtils jwtUtils,
    		UserRepository userRepository
    		) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }
    public LoginResponseDTO authenticate(LoginRequestDTO request) {
        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getUsername());
        return new LoginResponseDTO(token);
    }

    public UserResponseDTO register(RegisterRequestDTO request) {
        if (userService.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(
                userIdGenerator.getAndIncrement(),
                request.getUsername(),
                request.getEmail(),
                encodedPassword,
                UserRole.CITIZEN // default role
        );
        userService.save(user);
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
    public LoginResponseDTO createAnonymousUser() {
        User anonymous = new User();
        anonymous.setUsername("anon_" + UUID.randomUUID().toString().substring(0, 8));
        anonymous.setEmail(UUID.randomUUID() + "@anon.local");
        anonymous.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
        anonymous.setRole(UserRole.ANONYMOUS);

        userRepository.save(anonymous);

        String token = jwtUtils.generateToken(anonymous.getUsername());
        return new LoginResponseDTO(token);
    }
    

}
