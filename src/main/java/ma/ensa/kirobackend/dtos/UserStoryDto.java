package ma.ensa.kirobackend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.entities.Epic;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.Task;
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