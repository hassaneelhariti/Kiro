package ma.ensa.kirobackend.dtos;

import lombok.Data;
import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.ScrumMaster;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.UserStory;
import ma.ensa.kirobackend.enums.TaskStatus;


@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    private Long sprintBacklogId;
    private String  developerName;
    private String scrumMasterName;
    private String userStoryTitle;


}