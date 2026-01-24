package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.ProductBacklogDto;
import ma.ensa.kirobackend.entities.ProductBacklog;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EpicMapper.class)
public interface ProductBacklogMapper {

    @Mapping(target = "projetId", source = "projet.id")
    ProductBacklogDto toDto(ProductBacklog productBacklog);

    List<ProductBacklogDto> toDtoList(List<ProductBacklog> productBacklogs);

    @Mapping(target = "epicsList", ignore = true)
    @Mapping(target = "projet", ignore = true)
    ProductBacklog toEntity(ProductBacklogDto productBacklogDto);
}
