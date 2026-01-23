package ma.ensa.kirobackend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;


@Data
public class ProductBacklogDto {

    private Long id;

    @NotNull(message = "Project can not be null")
    private Long projetId;

    @NotBlank(message = "This can not be blank")
    private String name;

    private List<EpicDto> epicsList = new ArrayList<>();



}