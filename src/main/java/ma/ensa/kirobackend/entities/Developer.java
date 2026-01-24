package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
@Entity
@EqualsAndHashCode(callSuper = true)
public class Developer extends User{

    @ManyToMany(mappedBy = "developers")
    private List<Projet> projets = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    private List<Task> tasksList;


}
