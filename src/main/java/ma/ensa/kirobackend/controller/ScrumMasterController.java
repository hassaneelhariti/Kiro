package ma.ensa.kirobackend.controller;


import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.service.ScrumMasterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ScrumMasterController {
    private ScrumMasterService scrumMasterService;


    // create sprint
    @PostMapping("scrum-master/{id}/create-sprint")
    public SprintBacklogDto createSprint(@RequestBody SprintBacklogDto sprintBacklogDto){
        return scrumMasterService.saveSprint(sprintBacklogDto);
    }
    // Start / end sprint (change sprintStatus)
    @PutMapping("scrum-master/{id}/update-sprint")
    public void updateSprintStatus(@RequestBody SprintBacklogDto sprintBacklogDto){
        scrumMasterService.updateSprintStatus(sprintBacklogDto);
    }

    //Assign tasks to developers (create a task and assign it to a developer)
    @PutMapping("scrum-master/{id}/assigned-task")
    public  TaskDto assignTask(@RequestBody TaskDto taskDto){
        return scrumMasterService.assignTaskToDev(taskDto);
    }

    //Move user stories to sprint backlog
    @PutMapping("scrum-master/{id}/link-us")
    public SprintBacklogDto linkUsToSprint(@RequestBody SprintBacklogDto sprintBacklogDto){

        return scrumMasterService.linkUsToSprint(sprintBacklogDto) ;
    }

}
