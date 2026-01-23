package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.service.productownerservice.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/project/{id}")
    public ProjetDto getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @PostMapping("/project")
    public ProjetDto createProject(@Valid @RequestBody ProjetDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @PutMapping("/project/{id}/scrum-master/{scrumMasterId}")
    public void setScrumMaster(@PathVariable Long id, @PathVariable Long scrumMasterId) {
        projectService.setScrumMaster(id, scrumMasterId);
    }

    @PostMapping("/project/{id}/developer/{developerId}")
    public void addDeveloper(@PathVariable Long id, @PathVariable Long developerId) {
        projectService.addDeveloper(id, developerId);
    }

    @PutMapping("/project/{id}/product-backlog/{productBacklogId}")
    public void setProductBacklog(@PathVariable Long id, @PathVariable Long productBacklogId) {
        projectService.setProductBacklog(id, productBacklogId);
    }

    @PostMapping("/project/{id}/sprint/{sprintId}")
    public void addSprint(@PathVariable Long id, @PathVariable Long sprintId) {
        projectService.addSprint(id, sprintId);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}