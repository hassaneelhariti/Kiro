package ma.ensa.kirobackend.controller;


import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.service.ScrumMasterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/scrum-master")

public class ScrumMasterController {
    private ScrumMasterService scrumMasterService;


    // create sprint
    @PostMapping("/{id}/create-sprint")
    public ResponseEntity<SprintBacklogDto> createSprint(@RequestBody SprintBacklogDto sprintBacklogDto){
        SprintBacklogDto sprintBacklogDto1=scrumMasterService.saveSprint(sprintBacklogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body((sprintBacklogDto1));
    }
    // Start / end sprint (change sprintStatus)
    @PutMapping("/{id}/update-sprint")
    public ResponseEntity<String> updateSprintStatus(@RequestBody SprintBacklogDto sprintBacklogDto){
        scrumMasterService.updateSprintStatus(sprintBacklogDto);
        return ResponseEntity.ok("sprint status updated succesfully");
    }

    //Assign tasks to developers (create a task and assign it to a developer)
    @PutMapping("/{id}/assigned-task")
    public  ResponseEntity<TaskDto> assignTask(@RequestBody TaskDto taskDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(scrumMasterService.assignTaskToDev(taskDto));
    }

    //Move user stories to sprint backlog
    @PutMapping("/{id}/link-us")
    public ResponseEntity<SprintBacklogDto> linkUsToSprint(@RequestBody SprintBacklogDto sprintBacklogDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(scrumMasterService.linkUsToSprint(sprintBacklogDto) );
    }

}
