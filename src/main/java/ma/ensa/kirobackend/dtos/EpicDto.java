package ma.ensa.kirobackend.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;



@Data
public class EpicDto {

    private Long id;

    @NotBlank(message = "description can not be blank")
    private String description;

    private List<UserStoryDto> userStoriesList = new ArrayList<>();

    private Long productBacklogId;

}