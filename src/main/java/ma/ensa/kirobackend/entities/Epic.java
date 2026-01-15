package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "epic")
    private List<UserStory> userStoriesList;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

}