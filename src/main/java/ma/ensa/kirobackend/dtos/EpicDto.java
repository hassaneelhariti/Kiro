package ma.ensa.kirobackend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.entities.ProductBacklog;
import ma.ensa.kirobackend.entities.UserStory;

import java.util.ArrayList;
import java.util.List;



@Data
public class EpicDto {

    private Long id;

    private String description;

    private List<UserStoryDto> userStoriesList = new ArrayList<>();

    private ProductBacklog productBacklog;

}