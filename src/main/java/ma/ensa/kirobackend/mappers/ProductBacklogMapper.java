package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.ProductBacklogDto;
import ma.ensa.kirobackend.entities.ProductBacklog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EpicMapper.class})
public interface ProductBacklogMapper {

    ProductBacklogDto toDto(ProductBacklog productBacklog);

    @Mapping(target = "epicsList", ignore = true)
    ProductBacklog toEntity(ProductBacklogDto productBacklogDto);

}
