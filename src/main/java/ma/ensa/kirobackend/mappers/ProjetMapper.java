package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.entities.Projet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetMapper {

    @Mapping(target = "productOwnerId", source = "productOwner.id")
    @Mapping(target = "scrumMasterId", source = "scrumMaster.id")
    @Mapping(target = "productBacklogId", source = "productBacklog.id")
    @Mapping(target = "sprints", source = "sprintBacklogs")
    ProjetDto toDto(Projet projet);

    @Mapping(target = "productOwner", ignore = true)
    @Mapping(target = "scrumMaster", ignore = true)
    @Mapping(target = "productBacklog", ignore = true)
    @Mapping(target = "developers", ignore = true)
    @Mapping(target = "sprintBacklogs", ignore = true)
    Projet toProjet(ProjetDto projetDto);
}
