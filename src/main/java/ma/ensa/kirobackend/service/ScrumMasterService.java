package ma.ensa.kirobackend.service;

import ma.ensa.kirobackend.dtos.SprintBacklogDto;

public interface ScrumMasterService {
    SprintBacklogDto saveSprint(SprintBacklogDto sprintBacklogDto);

    // Start / end sprint (change sprintStatus)
    void updateSprintStatus(SprintBacklogDto sprintBacklogDto);
}
