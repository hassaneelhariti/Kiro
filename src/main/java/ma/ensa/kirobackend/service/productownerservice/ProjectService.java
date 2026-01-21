package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.ProjetDto;

public interface ProjectService {

    ProjetDto getProject(Long projectDtoId);

    ProjetDto createProject(ProjetDto projectDto);

    void deleteProject(Long projectDtoId);

}
