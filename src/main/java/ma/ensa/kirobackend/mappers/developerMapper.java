package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.UserStory;

public interface developerMapper {
    SprintBacklog toSprintBacklog(SprintBacklogDto sprintBacklogDto);

    SprintBacklogDto toSprintBacklogDto(SprintBacklog sprintBacklog);

    UserStoryDto toUserStoryDto(UserStory userStory);

    UserStory toUserStory(UserStoryDto userStoryDto);
}
