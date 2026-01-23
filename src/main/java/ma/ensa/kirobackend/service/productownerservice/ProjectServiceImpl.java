package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.entities.*;
import ma.ensa.kirobackend.exceptions.ProjectNotFoundException;
import ma.ensa.kirobackend.mappers.ProjetMapper;
import ma.ensa.kirobackend.repository.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjetRepository projetRepository;
    private ProjetMapper projetMapper;
    private ProductOwnerRepository productOwnerRepository;
    private ScrumMasterRepository scrumMasterRepository;
    private DeveloperRepository developerRepository;
    private ProductBacklogRepository productBacklogRepository;
    private SprintBacklogRepository sprintBacklogRepository;

    @Override
    public ProjetDto getProject(Long projectDtoId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        return projetMapper.toDto(projet);
    }

    @Override
    public ProjetDto createProject(ProjetDto projectDto) {
        Projet projet = projetMapper.toProjet(projectDto);

        // Set ProductOwner if productOwnerId is provided
        if (projectDto.getProductOwnerId() != null) {
            ProductOwner productOwner = productOwnerRepository.findById(projectDto.getProductOwnerId())
                    .orElseThrow(() -> new RuntimeException("ProductOwner not found"));
            projet.setProductOwner(productOwner);
        }

        // Set ScrumMaster if scrumMasterId is provided
        if (projectDto.getScrumMasterId() != null) {
            ScrumMaster scrumMaster = scrumMasterRepository.findById(projectDto.getScrumMasterId())
                    .orElseThrow(() -> new RuntimeException("ScrumMaster not found"));
            projet.setScrumMaster(scrumMaster);
        }

        // Set ProductBacklog if productBacklogId is provided
        if (projectDto.getProductBacklogId() != null) {
            ProductBacklog productBacklog = productBacklogRepository.findById(projectDto.getProductBacklogId())
                    .orElseThrow(() -> new RuntimeException("ProductBacklog not found"));
            projet.setProductBacklog(productBacklog);
        }

        Projet savedProjet = projetRepository.save(projet);
        return projetMapper.toDto(savedProjet);
    }

    @Override
    public void setScrumMaster(Long projectDtoId, Long scrumMasterId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        ScrumMaster scrumMaster = scrumMasterRepository.findById(scrumMasterId)
                .orElseThrow(() -> new RuntimeException("ScrumMaster not found"));

        projet.setScrumMaster(scrumMaster);
        projetRepository.save(projet);
    }

    @Override
    public void addDeveloper(Long projectDtoId, Long developerId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        // Add developer to project if not already added
        if (!projet.getDevelopers().contains(developer)) {
            projet.getDevelopers().add(developer);
            projetRepository.save(projet);
        }
    }

    @Override
    public void setProductBacklog(Long projectDtoId, Long productBacklogId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        ProductBacklog productBacklog = productBacklogRepository.findById(productBacklogId)
                .orElseThrow(() -> new RuntimeException("ProductBacklog not found"));

        projet.setProductBacklog(productBacklog);
        projetRepository.save(projet);
    }

    @Override
    public void addSprint(Long projectDtoId, Long sprintId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        SprintBacklog sprintBacklog = sprintBacklogRepository.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));


        // Add sprint to project if not already added
        if (!projet.getSprintBacklogs().contains(sprintBacklog)) {
            projet.getSprintBacklogs().add(sprintBacklog);
            sprintBacklog.setProjet(projet);
            projetRepository.save(projet);
        }
    }

    @Override
    public void deleteProject(Long projectDtoId) {
        Projet projet = projetRepository.findById(projectDtoId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        projetRepository.delete(projet);
    }
}