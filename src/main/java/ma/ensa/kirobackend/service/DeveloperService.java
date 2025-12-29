package ma.ensa.kirobackend.service;

import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.enums.TaskStatus;

import java.util.List;

public interface DeveloperService {
    List<TaskDto> allTasks(Long devId);

    TaskDto updateTaskStatus(Long taskId, TaskStatus taskStatus);

    //Consulter ses projets
    List<ProjetDto> viewProjects(Long devId);

    TaskDto createNewTask(TaskDto taskDto);

    // developer comment on exact post
    CommentDto commentOnTask(CommentDto commentDto);
}
