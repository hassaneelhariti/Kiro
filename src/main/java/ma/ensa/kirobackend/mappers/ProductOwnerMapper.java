package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.ProductOwnerDto;
import ma.ensa.kirobackend.entities.ProductBacklog;
import ma.ensa.kirobackend.entities.ProductOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductOwnerMapper {

    ProductOwnerDto toDto(ProductOwner productOwner);

    @Mapping(target = "ProductOwner.projects", ignore = true)
    ProductOwner toEntity(ProductOwnerDto productOwnerDto);
}
