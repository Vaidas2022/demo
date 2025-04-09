package lt.kauneta.edemocracy.auth.service;

import lt.kauneta.edemocracy.auth.model.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.*;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initUsers() {
        users.put("demo", new User(1L, "demo", "demo@example.com", passwordEncoder.encode("password123")));
        users.put("admin", new User(2L, "admin", "admin@example.com", passwordEncoder.encode("adminpass")));
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    public boolean existsByUsername(String username) {
        return users.containsKey(username);
    }

    public User save(User user) {
        users.put(user.getUsername(), user);
        return user;
    }
}
