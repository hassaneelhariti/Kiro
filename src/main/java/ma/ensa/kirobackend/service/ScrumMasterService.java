package ma.ensa.kirobackend.service;

import ma.ensa.kirobackend.dtos.DeveloperDto;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;

public interface ScrumMasterService {
    SprintBacklogDto saveSprint(SprintBacklogDto sprintBacklogDto);

    // Start / end sprint (change sprintStatus)
    void updateSprintStatus(SprintBacklogDto sprintBacklogDto);

    //Assign tasks to developers(req : devId , Task Id)
    TaskDto assignTaskToDev(TaskDto taskDto);
}
