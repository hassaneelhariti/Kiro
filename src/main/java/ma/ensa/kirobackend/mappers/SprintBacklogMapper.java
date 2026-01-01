package ma.ensa.kirobackend.mappers;


import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.entities.SprintBacklog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserStoryMapper.class)
public interface SprintBacklogMapper {
    //entity to dto
    @Mapping(target = "projetId",source = "projet.id")
    SprintBacklogDto sprintBacklogToDto(SprintBacklog sprintBacklog);

    // dto to entity
    @Mapping(target = "projet",ignore = true)
    @Mapping(target = "userStoriesList",ignore = true)
    SprintBacklog dtoToSprintBacklog(SprintBacklogDto sprintBacklogDto);


}
