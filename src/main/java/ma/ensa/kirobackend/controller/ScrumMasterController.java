package ma.ensa.kirobackend.controller;


import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.service.ScrumMasterService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/scrum-master")

public class ScrumMasterController {
    private ScrumMasterService scrumMasterService;


    // create sprint
    @PostMapping("/{id}/create-sprint")
    public SprintBacklogDto createSprint(@RequestBody SprintBacklogDto sprintBacklogDto){
        return scrumMasterService.saveSprint(sprintBacklogDto);
    }
    // Start / end sprint (change sprintStatus)
    @PutMapping("/{id}/update-sprint")
    public void updateSprintStatus(@RequestBody SprintBacklogDto sprintBacklogDto){
        scrumMasterService.updateSprintStatus(sprintBacklogDto);
    }

    //Assign tasks to developers (create a task and assign it to a developer)
    @PutMapping("/{id}/assigned-task")
    public  TaskDto assignTask(@RequestBody TaskDto taskDto){
        return scrumMasterService.assignTaskToDev(taskDto);
    }

    //Move user stories to sprint backlog
    @PutMapping("/{id}/link-us")
    public SprintBacklogDto linkUsToSprint(@RequestBody SprintBacklogDto sprintBacklogDto){

        return scrumMasterService.linkUsToSprint(sprintBacklogDto) ;
    }

}
