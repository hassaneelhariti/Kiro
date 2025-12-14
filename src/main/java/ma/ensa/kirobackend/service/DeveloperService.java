package ma.ensa.kirobackend.service;

import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;

import java.util.List;

public interface DeveloperService {
    List<TaskDto> allTasks(Long devId);

    TaskDto updateTaskStatus(Long taskId, TaskStatus taskStatus);
}
