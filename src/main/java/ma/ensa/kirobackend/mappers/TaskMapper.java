package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = CommentMapper.class)
public interface TaskMapper {

    // Entity → DTO
    @Mapping(target = "developerId", source = "developer.id")
    @Mapping(target = "scrumMasterId", source = "scrumMaster.id")
    @Mapping(target = "userStoryId", source = "userStory.id")
    @Mapping(target = "commentDtos", source = "comments")
    TaskDto taskToTaskDto(Task task);

    // DTO → Entity (relations gérées dans le service)
    @Mapping(target = "developer", ignore = true)
    @Mapping(target = "scrumMaster", ignore = true)
    @Mapping(target = "userStory", ignore = true)
    Task dtoToTask(TaskDto taskDto);

    List<TaskDto> toDtoList(List<Task> tasks);
}