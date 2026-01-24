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
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDto> getProject(@PathVariable Long id) {
        ProjetDto projectDto = projectService.getProject(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjetDto> createProject(@Valid @RequestBody ProjetDto projectDto) {
        ProjetDto createdProject = projectService.createProject(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PostMapping("/{id}/developer/{developerId}")
    public ResponseEntity<ProjetDto> addDeveloper(@PathVariable Long id, @PathVariable Long developerId) {
        ProjetDto updatedProject = projectService.addDeveloper(id, developerId);
        return ResponseEntity.ok(updatedProject);
    }


    @PostMapping("/{id}/sprint/{sprintId}")
    public ResponseEntity<ProjetDto> addSprint(@PathVariable Long id, @PathVariable Long sprintId) {
        ProjetDto updatedProject = projectService.addSprint(id, sprintId);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}