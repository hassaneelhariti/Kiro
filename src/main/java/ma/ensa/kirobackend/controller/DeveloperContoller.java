package ma.ensa.kirobackend.controller;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.service.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DeveloperContoller {
    private DeveloperService developerService;

    @GetMapping("developer/{id}/task")
    public List<TaskDto> getDevloperTasks(@PathVariable(name="id") Long id){
        return developerService.allTasks(id);
    }
}
