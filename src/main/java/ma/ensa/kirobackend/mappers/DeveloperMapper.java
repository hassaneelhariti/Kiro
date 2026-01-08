package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.DeveloperDto;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.UserStory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface DeveloperMapper {

    Developer toEntity(DeveloperDto developerDto);

    DeveloperDto toDto(Developer developer);

}
