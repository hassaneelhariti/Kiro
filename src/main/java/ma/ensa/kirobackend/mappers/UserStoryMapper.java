package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.UserStory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface UserStoryMapper {
    //entity to dto
    @Mapping(target = "epicId",source = "epic.id")
    @Mapping(target = "sprintBacklogId",source = "sprintBacklog.id")
    UserStoryDto toUserStoryDto(UserStory userStory);
    //to entity
    UserStory dtoToUserStory(UserStoryDto userStoryDto);

}
