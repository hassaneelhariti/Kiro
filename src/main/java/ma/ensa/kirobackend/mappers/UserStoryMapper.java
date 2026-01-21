package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.entities.UserStory;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface UserStoryMapper {
    //entity to dto
    @Mapping(target = "epicId",source = "epic.id")
    @Mapping(target = "sprintBacklogId",source = "sprintBacklog.id")
    UserStoryDto toUserStoryDto(UserStory userStory);

    List<TaskDto> toDtoList(List<Task> tasks);

    //to entity
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "epic", ignore = true)
    @Mapping(target = "sprintBacklog", ignore = true)
    UserStory dtoToUserStory(UserStoryDto userStoryDto);

}
