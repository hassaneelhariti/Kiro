package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.ProductBacklogDto;

public interface ProductBacklogService {

    ProductBacklogDto getProductBacklog(Long projectDtoId);

    ProductBacklogDto createProductBacklog(ProductBacklogDto productBacklogDto);

    void deleteProductBacklog(Long projectDtoId);

}
