package coid.bcaf.bebootcamp.service;


import coid.bcaf.bebootcamp.model.User;
import coid.bcaf.bebootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create a new user (registration)
    public User createUser(String username, String rawPassword, String role) {
        if (userRepository.existsById(username)) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        // Hash the password before storing it
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        user.setCreatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    // Login function that checks credentials
    public User login(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Verify the password
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null); // Returns user if found, otherwise null
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}