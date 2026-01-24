package ma.ensa.kirobackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ScrumMaster extends User{
    @JsonIgnore
    @OneToMany(mappedBy = "scrumMaster")
    List<Projet> projets;
    @JsonIgnore
    @OneToMany(mappedBy = "scrumMaster")
    private List<Task> tasksList;
}