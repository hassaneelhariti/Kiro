package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.enums.Status;

import java.util.List;


@Entity
@Data
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int priority;
    private Status status;

    @ManyToOne
    private Epic epic;

    @ManyToOne
    private SprintBacklog sprintBacklog;

    @OneToMany(mappedBy = "userStory")
    private List<Task> tasks;

}