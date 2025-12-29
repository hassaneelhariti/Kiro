package ma.ensa.kirobackend.dtos;

import lombok.Data;
import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.ScrumMaster;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.UserStory;
import ma.ensa.kirobackend.enums.TaskStatus;

import java.util.ArrayList;
import java.util.List;


@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    private Long  developerId;
    private Long scrumMasterId;
    private Long userStoryId;

    private List<CommentDto> commentDtos=new ArrayList<>();


}