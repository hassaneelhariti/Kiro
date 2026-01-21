package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.entities.Epic;
import ma.ensa.kirobackend.entities.ProductBacklog;
import ma.ensa.kirobackend.exceptions.EpicNotFoundException;
import ma.ensa.kirobackend.mappers.EpicMapper;
import ma.ensa.kirobackend.repository.EpicRepository;
import ma.ensa.kirobackend.repository.ProductBacklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpicServiceImpl implements EpicService {
    private EpicRepository epicRepository;
    private EpicMapper epicMapper;
    private ProductBacklogRepository productBacklogRepository;

    @Override
    public List<EpicDto> getAllEpics() {
        List<Epic> epics = epicRepository.findAll();
        return epicMapper.toDtoList(epics);
    }

    @Override
    public EpicDto getEpic(Long id) {
        Epic epic = epicRepository.findById(id)
                .orElseThrow(() -> new EpicNotFoundException("Epic not found"));

        return epicMapper.toDto(epic);
    }

    @Override
    public EpicDto createEpic(EpicDto epicDto) {
        Epic epic = epicMapper.toEntity(epicDto);

        // Set ProductBacklog if productBacklogId is provided
        if (epicDto.getProductBacklogId() != null) {
            ProductBacklog productBacklog = productBacklogRepository.findById(epicDto.getProductBacklogId())
                    .orElseThrow(() -> new RuntimeException("ProductBacklog not found"));
            epic.setProductBacklog(productBacklog);
        }

        Epic savedEpic = epicRepository.save(epic);
        return epicMapper.toDto(savedEpic);
    }

    @Override
    public void deleteEpic(Long id) {
        Epic epic = epicRepository.findById(id)
                .orElseThrow(() -> new EpicNotFoundException("Epic not found"));

        epicRepository.delete(epic);
    }
}