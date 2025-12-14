package ma.ensa.kirobackend.service;


import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.exceptions.UserNotFoundException;
import ma.ensa.kirobackend.mappers.TaskMapper;
import ma.ensa.kirobackend.repository.DeveloperRepository;
import ma.ensa.kirobackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService{
    private TaskRepository taskRepository;
    private DeveloperRepository developerRepository;
    private TaskMapper taskMapper;

    @Override
    public List<TaskDto> allTasks(Long devId){
        Developer developer=developerRepository.findById(devId).orElse(null);
        if(developer==null) throw new UserNotFoundException("Developer not Found");

        List<Task> devTasks=taskRepository.findAllByDeveloperId(developer.getId());
        List<TaskDto> devTasksDto=new ArrayList<>();
        for (Task task : devTasks ){
            TaskDto taskDto=taskMapper.taskToTaskDto(task);
            devTasksDto.add(taskDto);
        }
        return devTasksDto;
    }
}
