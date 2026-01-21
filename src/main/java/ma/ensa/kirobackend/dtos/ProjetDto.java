package ma.ensa.kirobackend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Data
public class ProjetDto {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    private Long productOwnerId;
    private Long scrumMasterId;

    private List<DeveloperDto> developers = new ArrayList<>();

    private Long productBacklogId;

    private List<SprintDto> sprints;



}
