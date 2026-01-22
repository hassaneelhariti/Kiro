package ma.ensa.kirobackend.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import ma.ensa.kirobackend.enums.Status;

import java.util.List;

@Data
public class UserStoryDto {
    private Long id; // No @Id or @GeneratedValue here!

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @Min(value = 1, message = "Priority must be at least 1")
    @Max(value = 3, message = "Priority must be at most 10")
    private int priority;

    private Status status;

    private Long epicId;

    private Long sprintBacklogId;

    private List<TaskDto> tasks;
}