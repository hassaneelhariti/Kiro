package ma.ensa.kirobackend.controller;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.service.DeveloperService;
import ma.ensa.kirobackend.service.SprintBacklogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DeveloperContoller {
    private DeveloperService developerService;
    private SprintBacklogService sprintBacklogService;

    @GetMapping("developer/{id}/task")
    public List<TaskDto> getDevloperTasks(@PathVariable(name="id") Long id){
        return developerService.allTasks(id);
    }

    @PutMapping("developer/{id}/task/{taskId}")
    public TaskDto updateTaskStatus(@PathVariable(name="taskId") Long taskId, @RequestParam(name = "taskStatus") TaskStatus taskStatus){
        return developerService.updateTaskStatus(taskId ,taskStatus);
    }

    @GetMapping("developer/{id}/Sprint-Backlog/{sprintBacklogID}")
    public SprintBacklogDto viewSprintBacklog(@PathVariable(name = "sprintBacklogID") Long sprintBacklogId, @PathVariable String id){
        return sprintBacklogService.viewSprintBacklog(sprintBacklogId);
    }
}
