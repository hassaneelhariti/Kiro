package ma.ensa.kirobackend.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;


@Data
public class ProductBacklogDto {

    private Long id;

    private Long projetId;

    @NotBlank(message = "This can not be blank")
    private String name;

    private List<EpicDto> epicsList = new ArrayList<>();



}