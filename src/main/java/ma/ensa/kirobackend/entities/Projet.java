package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private ProductOwner productOwner;
    @ManyToOne
    private ScrumMaster scrumMaster;

    @ManyToMany
    @JoinTable(
            name = "developer_projet",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developers = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

    @OneToMany(mappedBy = "projet")
    private List<SprintBacklog> sprintBacklogs;



}
