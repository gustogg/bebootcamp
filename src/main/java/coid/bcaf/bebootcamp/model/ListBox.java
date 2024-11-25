package coid.bcaf.bebootcamp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String no_box;
    private String created_date;
    private String approved;
    private String sampled;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getno_box() { return no_box; }
    public void setno_box(String no_box) { this.no_box = no_box; }

    public String getcreated_date() { return created_date; }
    public void setcreated_date(String created_date) { this.created_date = created_date; }

    public String getapproved() { return approved; }
    public void setapproved(String approved) { this.approved = approved; }

    public String getsampled() { return sampled; }
    public void setsampled(String sampled) { this.sampled = sampled; }
}

