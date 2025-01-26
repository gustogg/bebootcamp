package coid.bcaf.bebootcamp.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ListBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String no_box;
    private String approved;
    private String sampled;
    @Column(name = "created_date", updatable = false, insertable = false)
    private LocalDateTime createdDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getno_box() { return no_box; }
    public void setno_box(String no_box) { this.no_box = no_box; }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getapproved() { return approved; }
    public void setapproved(String approved) { this.approved = approved; }

    public String getsampled() { return sampled; }
    public void setsampled(String sampled) { this.sampled = sampled; }
}

