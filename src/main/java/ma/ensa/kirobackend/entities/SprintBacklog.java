package ma.ensa.kirobackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ma.ensa.kirobackend.enums.SprintStatus;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class SprintBacklog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate startDate; // When the sprint begins
    private LocalDate endDate;
    private String goal;
    @Enumerated(EnumType.STRING)
    private SprintStatus status;
    @ManyToOne
    private Projet projet;

    @JsonIgnore
    @OneToMany(mappedBy = "sprintBacklog")
    private List<UserStory> userStoriesList;



}