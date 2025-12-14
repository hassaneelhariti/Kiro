package ma.ensa.kirobackend.controller;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DeveloperContoller {
    private DeveloperService developerService;

    @GetMapping("developer/{id}/task")
    public List<TaskDto> getDevloperTasks(@PathVariable(name="id") Long id){
        return developerService.allTasks(id);
    }

    @PutMapping("developer/{id}/task/{taskId}")
    public TaskDto updateTaskStatus(@PathVariable(name="taskId") Long taskId, @RequestParam(name = "taskStatus") TaskStatus taskStatus){
        return developerService.updateTaskStatus(taskId ,taskStatus);
    }
}
