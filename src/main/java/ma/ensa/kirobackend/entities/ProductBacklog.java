package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class ProductBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "productBacklog")
    private Projet projet;

    private String name;
//    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "productBacklog")
    private List<Epic> epicsList;



}