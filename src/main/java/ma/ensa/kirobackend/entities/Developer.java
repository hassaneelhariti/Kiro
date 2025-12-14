package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Developer extends User{

    @ManyToMany(mappedBy = "developers")
    private List<Projet> projets = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    private List<Task> tasksList;


}
