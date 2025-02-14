package coid.bcaf.bebootcamp.controller;

import coid.bcaf.bebootcamp.model.User;
import coid.bcaf.bebootcamp.repository.UserRepository;
import coid.bcaf.bebootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.jsonwebtoken.Jwts;
import java.util.Collections;
import java.util.Map;
import coid.bcaf.bebootcamp.security.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil; // Inject JwtUtil


    // Endpoint for user registration
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.createUser(request.getUsername(), request.getPassword(), request.getRole());
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.login(request.getUsername(), request.getPassword());
        String token = jwtUtil.generateToken(user.getUsername()); // Generate the token
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}

// DTO for registration request
class RegisterRequest {
    private String username;
    private String password;
    private String role;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

// DTO for login request
class LoginRequest {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
