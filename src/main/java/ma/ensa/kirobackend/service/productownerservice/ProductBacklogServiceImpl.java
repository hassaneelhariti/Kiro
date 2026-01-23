package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.dtos.ProductBacklogDto;
import ma.ensa.kirobackend.entities.Epic;
import ma.ensa.kirobackend.entities.ProductBacklog;
import ma.ensa.kirobackend.entities.Projet;
import ma.ensa.kirobackend.exceptions.ProductBacklogNotFoundException;
import ma.ensa.kirobackend.mappers.EpicMapper;
import ma.ensa.kirobackend.mappers.ProductBacklogMapper;
import ma.ensa.kirobackend.repository.EpicRepository;
import ma.ensa.kirobackend.repository.ProductBacklogRepository;
import ma.ensa.kirobackend.repository.ProjetRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBacklogServiceImpl implements ProductBacklogService {
    private ProductBacklogRepository productBacklogRepository;
    private ProductBacklogMapper productBacklogMapper;
    private ProjetRepository projetRepository;
    private EpicRepository epicRepository;
    private EpicMapper epicMapper;

    @Override
    public ProductBacklogDto getProductBacklog(Long projectDtoId) {
        ProductBacklog productBacklog = productBacklogRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProductBacklogNotFoundException("ProductBacklog not found"));

        return productBacklogMapper.toDto(productBacklog);
    }

    @Override
    public ProductBacklogDto createProductBacklog(ProductBacklogDto productBacklogDto) {
        ProductBacklog productBacklog = productBacklogMapper.toEntity(productBacklogDto);

        if(productBacklog.getEpicsList().isEmpty()){
            Epic defaultEpic = new Epic();
            defaultEpic.setDescription("Default epic");
            defaultEpic.setProductBacklog(productBacklog);
            productBacklog.getEpicsList().add(defaultEpic);
        }

        if (productBacklogDto.getProjetId() != null) {
            Projet projet = projetRepository.findById(productBacklogDto.getProjetId())
                    .orElseThrow(() -> new RuntimeException("Projet not found"));
            productBacklog.setProjet(projet);
        }

        ProductBacklog savedProductBacklog = productBacklogRepository.save(productBacklog);
        return productBacklogMapper.toDto(savedProductBacklog);
    }

    @Override
    public EpicDto addEpicToProductBacklog(Long productBacklogId, EpicDto epicDto) {
        ProductBacklog productBacklog = productBacklogRepository.findById(productBacklogId)
                .orElseThrow(() -> new ProductBacklogNotFoundException("ProductBacklog not found"));

        Epic epic = epicMapper.toEntity(epicDto);
        epic.setProductBacklog(productBacklog);

        Epic savedEpic = epicRepository.save(epic);
        return epicMapper.toDto(savedEpic);
    }

    @Override
    public void deleteProductBacklog(Long projectDtoId) {
        ProductBacklog productBacklog = productBacklogRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProductBacklogNotFoundException("ProductBacklog not found"));

        productBacklogRepository.delete(productBacklog);
    }
}