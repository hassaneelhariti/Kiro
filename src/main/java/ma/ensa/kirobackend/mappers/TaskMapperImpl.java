package ma.ensa.kirobackend.mappers;

import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class TaskMapperImpl implements TaskMapper{

    @Override
    public TaskDto taskToTaskDto(Task task){
        TaskDto taskDto=new TaskDto();
        BeanUtils.copyProperties(task,taskDto);
        taskDto.setDeveloperName(task.getDeveloper().getNom());
        taskDto.setScrumMasterName(task.getScrumMaster().getNom());
        taskDto.setSprintBacklogId(task.getSprintBacklog().getId());
        taskDto.setUserStoryTitle(task.getUserStory().getTitle());

        return taskDto;
    }
    @Override
    public Task dtoToTask(TaskDto taskDto){
        Task task=new Task();
        BeanUtils.copyProperties(taskDto,task);
        return task;
    }
}
