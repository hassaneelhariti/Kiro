package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.entities.Epic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EpicMapper {

    @Mapping(target = "productBacklogId", source = "productBacklog.id")
    EpicDto toDto(Epic epic);

    List<EpicDto> toDtoList(List<Epic> epics);

    @Mapping(target = "userStoriesList", ignore = true)
    @Mapping(target = "productBacklog", ignore = true)
    Epic toEntity(EpicDto epicDto);

}
