package ma.ensa.kirobackend.dtos;

import lombok.Data;
import ma.ensa.kirobackend.enums.Status;

import java.util.List;



@Data
public class UserStoryDto {
    private Long id;
    private String title;
    private String description;
    private int priority;
    private Status status;

    private Long epicId;
    private Long sprintBacklogId;

    private List<TaskDto> tasks;
}