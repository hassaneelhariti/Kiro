package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.ProjetDto;

public interface ProjectService {
    ProjetDto getProject(Long projectDtoId);

    ProjetDto createProject(ProjetDto projectDto);

    ProjetDto setScrumMaster(Long projectDtoId, Long scrumMasterId);

    ProjetDto addDeveloper(Long projectDtoId, Long developerId);

    ProjetDto setProductBacklog(Long projectDtoId, Long productBacklogId);

    ProjetDto addSprint(Long projectDtoId, Long sprintId);

    void deleteProject(Long projectDtoId);
}