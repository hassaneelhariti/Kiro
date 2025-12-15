package ma.ensa.kirobackend.mappers;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.entities.UserStory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SprintBacklogMapperImpl implements SprintBacklogMapper{
    private TaskMapper taskMapper;

    @Override
    public SprintBacklog toSprintBacklog(SprintBacklogDto sprintBacklogDto){
        SprintBacklog sprintBacklog=new SprintBacklog();
        BeanUtils.copyProperties(sprintBacklogDto,sprintBacklog);
        return sprintBacklog;
    }

    @Override
    public SprintBacklogDto toSprintBacklogDto(SprintBacklog sprintBacklog) {
        SprintBacklogDto sprintBacklogDto=new SprintBacklogDto();
        BeanUtils.copyProperties(sprintBacklog,sprintBacklogDto);
        List<UserStoryDto> userStoryDtos=new ArrayList<>();
        for (UserStory userStory : sprintBacklog.getUserStoriesList()){
            userStoryDtos.add(toUserStoryDto(userStory));
        }
        sprintBacklogDto.setUserStoriesList(userStoryDtos);
        return sprintBacklogDto;
    }

    @Override
    public UserStoryDto toUserStoryDto(UserStory userStory) {
        UserStoryDto userStoryDto=new UserStoryDto();
        BeanUtils.copyProperties(userStory,userStoryDto);
        List<TaskDto> taskDtos=new ArrayList<>();
        for (Task task : userStory.getTasks()){
            taskDtos.add(taskMapper.taskToTaskDto(task));
        }
        userStoryDto.setTasks(taskDtos);
        return userStoryDto;
    }
    @Override
    public UserStory toUserStory(UserStoryDto userStoryDto) {
        UserStory userStory=new UserStory();
        BeanUtils.copyProperties(userStoryDto,userStory);
        return userStory;
    }


}
