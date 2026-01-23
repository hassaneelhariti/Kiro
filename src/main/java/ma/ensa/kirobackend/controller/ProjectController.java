package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.service.productownerservice.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/project/{id}")
    public ResponseEntity<ProjetDto> getProject(@PathVariable Long id) {
        ProjetDto projectDto = projectService.getProject(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping("/project")
    public ResponseEntity<ProjetDto> createProject(@Valid @RequestBody ProjetDto projectDto) {
        ProjetDto createdProject = projectService.createProject(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping("/project/{id}/scrum-master/{scrumMasterId}")
    public ResponseEntity<Void> setScrumMaster(@PathVariable Long id, @PathVariable Long scrumMasterId) {
        projectService.setScrumMaster(id, scrumMasterId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/project/{id}/developer/{developerId}")
    public ResponseEntity<Void> addDeveloper(@PathVariable Long id, @PathVariable Long developerId) {
        projectService.addDeveloper(id, developerId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/project/{id}/product-backlog/{productBacklogId}")
    public ResponseEntity<Void> setProductBacklog(@PathVariable Long id, @PathVariable Long productBacklogId) {
        projectService.setProductBacklog(id, productBacklogId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/project/{id}/sprint/{sprintId}")
    public ResponseEntity<Void> addSprint(@PathVariable Long id, @PathVariable Long sprintId) {
        projectService.addSprint(id, sprintId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}