package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.ProjetDto;

public interface ProjectService {

    ProjetDto getProject(Long projectDtoId);

    ProjetDto createProject(ProjetDto projectDto);
    
    void setScrumMaster(Long projectDtoId, Long scrumMasterId);

    void addDeveloper(Long projectDtoId, Long developerId);

    void setProductBacklog(Long projectDtoId, Long productBacklogId);

    void addSprint(Long projectDtoId, Long sprintId);

    void deleteProject(Long projectDtoId);

}
