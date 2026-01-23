package ma.ensa.kirobackend.controller;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.service.DeveloperService;
import ma.ensa.kirobackend.service.SprintBacklogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {
    private DeveloperService developerService;
    private SprintBacklogService sprintBacklogService;

    @GetMapping("/{id}/task")
    public List<TaskDto> getDevloperTasks(@PathVariable(name="id") Long id){
        return developerService.allTasks(id);
    }

    @PutMapping("/{id}/task/{taskId}")
    public TaskDto updateTaskStatus(@PathVariable(name="taskId") Long taskId, @RequestParam(name = "taskStatus") TaskStatus taskStatus){
        return developerService.updateTaskStatus(taskId ,taskStatus);
    }
    // temp
    @GetMapping("/{id}/Sprint-Backlog/{sprintBacklogID}")
    public SprintBacklogDto viewSprintBacklog(@PathVariable(name = "sprintBacklogID") Long sprintBacklogId, @PathVariable String id){
        return sprintBacklogService.viewSprintBacklog(sprintBacklogId);
    }

    //Consulter ses projets
    @GetMapping("/{id}/projet")
    public List<ProjetDto> viewMyProjects(@PathVariable Long id){
        return developerService.viewProjects(id);
    }


    // create own task
    @PostMapping("/{id}/create-task")
    public TaskDto createOwnTask(@RequestBody TaskDto task){
        return developerService.createNewTask(task);
    }

    //comment to task
    @PostMapping("/{id}/comment")
    public CommentDto commentOnTask(@RequestBody CommentDto commentDto){
        return developerService.commentOnTask(commentDto);
    }

}
