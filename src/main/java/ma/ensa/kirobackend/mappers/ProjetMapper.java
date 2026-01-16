package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.entities.Projet;

public interface ProjetMapper {

    ProjetDto toDto(Projet projet);

    Projet toProjet(ProjetDto projetDto);
}
