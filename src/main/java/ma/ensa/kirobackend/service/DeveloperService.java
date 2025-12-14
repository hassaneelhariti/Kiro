package ma.ensa.kirobackend.service;

import ma.ensa.kirobackend.dtos.TaskDto;

import java.util.List;

public interface DeveloperService {
    List<TaskDto> allTasks(Long devId);
}
