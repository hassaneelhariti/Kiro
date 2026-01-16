package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.entities.Epic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EpicMapper {

    @Mapping(target = "productBacklogId", source = "productBacklog.id")
    EpicDto toDto(Epic epic);

    @Mapping(target = "userStoriesList", ignore = true)
    @Mapping(target = "productBacklog")
    Epic toEntity(EpicDto epicDto);

}
