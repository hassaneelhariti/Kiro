package ma.ensa.kirobackend.dtos;


import lombok.Data;
import ma.ensa.kirobackend.enums.SprintStatus;

import java.time.LocalDate;
import java.util.List;



@Data
public class SprintBacklogDto {
    private Long id;
    private String name;
    private LocalDate startDate; // When the sprint begins
    private LocalDate endDate;
    private String goal;
    private SprintStatus status;
    private List<UserStoryDto> userStoriesList;
    private Long projetId;

}