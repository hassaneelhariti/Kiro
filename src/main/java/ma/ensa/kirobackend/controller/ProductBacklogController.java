package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.dtos.ProductBacklogDto;
import ma.ensa.kirobackend.service.productownerservice.ProductBacklogService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductBacklogController {
    private ProductBacklogService productBacklogService;

    @GetMapping("/product-backlog/{id}")
    public ProductBacklogDto getProductBacklog(@PathVariable Long id) {
        return productBacklogService.getProductBacklog(id);
    }

    @PostMapping("/product-backlog")
    public ProductBacklogDto createProductBacklog(@Valid @RequestBody ProductBacklogDto productBacklogDto) {
        return productBacklogService.createProductBacklog(productBacklogDto);
    }

    @PostMapping("/product-backlog/{id}/epic")
    public EpicDto addEpicToProductBacklog(@PathVariable Long id, @Valid @RequestBody EpicDto epicDto) {
        return productBacklogService.addEpicToProductBacklog(id, epicDto);
    }

    @DeleteMapping("/product-backlog/{id}")
    public void deleteProductBacklog(@PathVariable Long id) {
        productBacklogService.deleteProductBacklog(id);
    }
}