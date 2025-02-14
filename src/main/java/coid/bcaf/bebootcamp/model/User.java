package coid.bcaf.bebootcamp.model;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users") // Changed table name
public class User {

    @Id
    @Column(length = 50)
    private String username;

    private String password;

    private String role;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    // Constructors
    public User() {
    }

    public User(String username, String password, String role, LocalDateTime createdDate) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

