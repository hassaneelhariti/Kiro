package ma.ensa.kirobackend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.ensa.kirobackend.entities.Epic;

import java.util.List;


@Data
public class ProductBacklogDto {

    private Long id;

    private String name;
    private List<EpicDto> epicsList;



}