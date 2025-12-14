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

    private ProductOwner productOwner;
    private ScrumMaster scrumMaster;

    private List<Developer> developers = new ArrayList<>();

    private ProductBacklog productBacklog;

    private List<Sprint> sprints;



}
