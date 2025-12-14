package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Task;

public interface TaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task dtoToTask(TaskDto taskDto);
}
