package ma.ensa.kirobackend.mappers;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.repository.DeveloperRepository;
import ma.ensa.kirobackend.repository.ScrumMasterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TaskMapperImpl implements TaskMapper{
    private DeveloperRepository developerRepository;
    private ScrumMasterRepository scrumMasterRepository;
    @Override
    public TaskDto taskToTaskDto(Task task){
        TaskDto taskDto=new TaskDto();
        BeanUtils.copyProperties(task,taskDto);
        taskDto.setDeveloperId(task.getDeveloper().getId());
        taskDto.setScrumMasterId(task.getScrumMaster().getId());
        taskDto.setSprintBacklogId(task.getSprintBacklog().getId());
        taskDto.setUserStoryId(task.getUserStory().getId());

        return taskDto;
    }
    @Override
    public Task dtoToTask(TaskDto taskDto){
        Task task=new Task();
        BeanUtils.copyProperties(taskDto,task);
        
        return task;
    }
}
