package ma.ensa.kirobackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.enums.TaskStatus;

@Entity
@Data
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
//    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @OneToOne
    private SprintBacklog sprintBacklog;
    @JsonIgnore // pour ignorer liste lorsque il fait la serialisation en json on aura une boucle entre bankaccount et customer
    @ManyToOne
    private Developer developer;

    @JsonIgnore
    @ManyToOne
    private ScrumMaster scrumMaster;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;


}