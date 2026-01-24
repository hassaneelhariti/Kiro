package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.ProjetDto;

public interface ProjectService {
    ProjetDto getProject(Long projectDtoId);

    ProjetDto createProject(ProjetDto projectDto);

    ProjetDto addDeveloper(Long projectDtoId, Long developerId);

    ProjetDto addSprint(Long projectDtoId, Long sprintId);

    void deleteProject(Long projectDtoId);
}