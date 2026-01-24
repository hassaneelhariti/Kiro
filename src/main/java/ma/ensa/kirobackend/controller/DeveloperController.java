package ma.ensa.kirobackend.controller;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.service.DeveloperService;
import ma.ensa.kirobackend.service.SprintBacklogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {
    private DeveloperService developerService;
    private SprintBacklogService sprintBacklogService;

    @GetMapping("/{id}/task")
    public ResponseEntity<List<TaskDto>> getDevloperTasks(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(developerService.allTasks(id));
    }

    @PutMapping("/{id}/task/{taskId}")
    public ResponseEntity<TaskDto> updateTaskStatus(@PathVariable(name="taskId") Long taskId, @RequestParam(name = "taskStatus") TaskStatus taskStatus){
        TaskDto taskDto=developerService.updateTaskStatus(taskId ,taskStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskDto);
    }
    // temp
    @GetMapping("/{id}/Sprint-Backlog/{sprintBacklogID}")
    public ResponseEntity<SprintBacklogDto> viewSprintBacklog(@PathVariable(name = "sprintBacklogID") Long sprintBacklogId, @PathVariable String id){
        return ResponseEntity.ok(sprintBacklogService.viewSprintBacklog(sprintBacklogId));
    }

    //Consulter ses projets
    @GetMapping("/{id}/projet")
    public ResponseEntity<List<ProjetDto>> viewMyProjects(@PathVariable Long id){
        return ResponseEntity.ok(developerService.viewProjects(id));
    }


    // create own task
    @PostMapping("/{id}/create-task")
    public ResponseEntity<TaskDto> createOwnTask(@RequestBody TaskDto task){
        return ResponseEntity.status(HttpStatus.CREATED).body(developerService.createNewTask(task));
    }

    //comment to task
    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> commentOnTask(@RequestBody CommentDto commentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(developerService.commentOnTask(commentDto));
    }

}
