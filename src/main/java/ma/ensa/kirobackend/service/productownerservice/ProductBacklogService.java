package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.dtos.ProductBacklogDto;

public interface ProductBacklogService {

    ProductBacklogDto getProductBacklog(Long projectDtoId);

    ProductBacklogDto createProductBacklog(ProductBacklogDto productBacklogDto);

    // Add Epic to ProductBacklog
    EpicDto addEpicToProductBacklog(Long productBacklogId, EpicDto epicDto);

    void deleteProductBacklog(Long projectDtoId);

}