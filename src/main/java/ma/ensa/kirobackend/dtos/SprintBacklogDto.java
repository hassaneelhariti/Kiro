package ma.ensa.kirobackend.dtos;


import lombok.Data;
import ma.ensa.kirobackend.entities.UserStory;

import java.util.List;



@Data
public class SprintBacklogDto {
    private Long id;
    private String name;
    private List<UserStoryDto> userStoriesList;

}