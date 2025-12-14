package ma.ensa.kirobackend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import ma.ensa.kirobackend.entities.Projet;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.entities.User;

import java.util.List;



@Data
public class ScrumMasterDto extends User {

    List<Projet> projets;
    private List<Task> tasksList;
}