package coid.bcaf.bebootcamp.service;


import coid.bcaf.bebootcamp.model.User;
import coid.bcaf.bebootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean loginUser(String username, String rawPassword) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            // Compare raw password with hashed password
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }
}
