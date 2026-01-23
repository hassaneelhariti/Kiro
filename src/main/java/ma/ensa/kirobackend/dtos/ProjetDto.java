package ma.ensa.kirobackend.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProjetDto {

    private Long id;

//    @NotBlank(message = "Project name is required")
    @Size(max = 100, message = "Project name must not exceed 100 characters")
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

//    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date cannot be in the future")
    private Date startDate;

//    @NotNull(message = "End date is required")
    @FutureOrPresent(message = "End date must be today or in the future")
    private Date endDate;

    // ================= Relations (IDs only) =================

//    @NotNull(message = "Product Owner is required")
    private Long productOwnerId;

//    @NotNull(message = "Scrum Master is required")
    private Long scrumMasterId;

//    @NotNull(message = "Developers list cannot be null")
    private List<DeveloperDto> developers = new ArrayList<>();

    private Long productBacklogId;

//    @NotNull(message = "Sprints list cannot be null")
    private List<SprintDto> sprints = new ArrayList<>();
}
