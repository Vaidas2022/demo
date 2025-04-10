package lt.kauneta.edemocracy.auth.service;

import lt.kauneta.edemocracy.auth.model.User;
import lt.kauneta.edemocracy.auth.repositories.UserRepository;
import lt.kauneta.edemocracy.security.JwtAuthFilter;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public Long getCurrentUserId() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();		
		
		return userRepository.findByUsername(username).map(User::getId)
				.orElseThrow(() -> new RuntimeException("User not found in context"));
	}
}
