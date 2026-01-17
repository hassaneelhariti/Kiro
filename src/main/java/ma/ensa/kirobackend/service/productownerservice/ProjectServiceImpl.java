package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.entities.Projet;
import ma.ensa.kirobackend.mappers.ProjetMapper;
import ma.ensa.kirobackend.repository.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjetRepository projetRepository;
    private final ProductOwnerRepository productOwnerRepository;
    private final ScrumMasterRepository scrumMasterRepository;
    private final ProductBacklogRepository productBacklogRepository;
    private final DeveloperRepository developerRepository;
    private final SprintBacklogRepository sprintBacklogRepository;
    private final ProjetMapper projetMapper;


    @Override
    public ProjetDto getProject(Long projectDtoId){
        Projet pojet = projetRepository.findById(projectDtoId).orElseThrow(()->new RuntimeException("Project Not Found"));
        return projetMapper.toDto(pojet);
    }

    @Override
    public ProjetDto createProject(ProjetDto projectDto){

        return null;
    }

    @Override
    public void deleteProject(Long projectDtoId){

    }


}
