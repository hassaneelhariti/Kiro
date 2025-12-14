package ma.ensa.kirobackend.dtos;


import lombok.Data;
import ma.ensa.kirobackend.entities.Projet;
import ma.ensa.kirobackend.entities.Task;
import java.util.ArrayList;
import java.util.List;

@Data
public class DeveloperDto extends UserDto {

    private Long id;
    private List<ProjetDto> projets = new ArrayList<>();
//    private List<Task> tasksList;


}
