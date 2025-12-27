package ma.ensa.kirobackend.dtos;

import lombok.Data;
import ma.ensa.kirobackend.entities.Projet;

@Data
public class SprintDto {

    private Long id;
    private String projetName;
}
