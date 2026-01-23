package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.dtos.ProductBacklogDto;
import ma.ensa.kirobackend.service.productownerservice.ProductBacklogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductBacklogController {
    private ProductBacklogService productBacklogService;

    @GetMapping("/product-backlog/{id}")
    public ResponseEntity<ProductBacklogDto> getProductBacklog(@PathVariable Long id) {
        ProductBacklogDto productBacklogDto = productBacklogService.getProductBacklog(id);
        return ResponseEntity.ok(productBacklogDto);
    }

    @PostMapping("/product-backlog")
    public ResponseEntity<ProductBacklogDto> createProductBacklog(@Valid @RequestBody ProductBacklogDto productBacklogDto) {
        ProductBacklogDto productBacklogDtoCreated = productBacklogService.createProductBacklog(productBacklogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productBacklogDtoCreated);
    }

    @PostMapping("/product-backlog/{id}/epic")
    public ResponseEntity<EpicDto> addEpicToProductBacklog(@PathVariable Long id, @Valid @RequestBody EpicDto epicDto) {
        EpicDto epicDtoAdded = productBacklogService.addEpicToProductBacklog(id, epicDto);
        return ResponseEntity.ok(epicDtoAdded);
    }

    @DeleteMapping("/product-backlog/{id}")
    public ResponseEntity<Void> deleteProductBacklog(@PathVariable Long id) {
        productBacklogService.deleteProductBacklog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}