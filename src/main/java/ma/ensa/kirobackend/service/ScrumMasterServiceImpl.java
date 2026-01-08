package ma.ensa.kirobackend.service;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.*;
import ma.ensa.kirobackend.mappers.SprintBacklogMapper;
import ma.ensa.kirobackend.mappers.TaskMapper;
import ma.ensa.kirobackend.mappers.UserStoryMapper;
import ma.ensa.kirobackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScrumMasterServiceImpl implements ScrumMasterService{
    private final TaskRepository taskRepository;
    private final DeveloperRepository developerRepository;
    private final ScrumMasterRepository scrumMasterRepository;
    private final UserStoryRepository userStoryRepository;
    private ProjetRepository projetRepository;
    private UserStoryMapper userStoryMapper;
    private SprintBacklogMapper sprintBacklogMapper;
    private SprintBacklogRepository sprintBacklogRepository;
    private TaskMapper taskMapper;
    private EpicRepository epicRepository;

    @Override
    public SprintBacklogDto saveSprint(SprintBacklogDto sprintBacklogDto)  {
        Projet projet=projetRepository.findById(sprintBacklogDto.getProjetId()).orElseThrow(()->new RuntimeException("Projet not found"));
        List<UserStory> userStories=new ArrayList<>();
        for (UserStoryDto userStoryDto :sprintBacklogDto.getUserStoriesList() ){
            UserStory userStory=userStoryMapper.dtoToUserStory(userStoryDto);
            List<Task> tasks=new ArrayList<>();
            for (TaskDto taskDto:userStoryDto.getTasks()){
                tasks.add(taskMapper.dtoToTask(taskDto));
            }
            userStory.setEpic(epicRepository.findById(userStoryDto.getEpicId()).orElseThrow(()->new RuntimeException("Epic not Found")));
            userStories.add(userStory);
        }
        SprintBacklog sprintBacklog =sprintBacklogMapper.dtoToSprintBacklog(sprintBacklogDto);
        sprintBacklog.setProjet(projet);
        sprintBacklog.setUserStoriesList(userStories);
        SprintBacklog sprintBacklog1=sprintBacklogRepository.save(sprintBacklog);
        return sprintBacklogMapper.sprintBacklogToDto(sprintBacklog1);
    }
    // Start / end sprint (change sprintStatus)
    @Override
    public void updateSprintStatus(SprintBacklogDto sprintBacklogDto){
        SprintBacklog sprintBacklog=sprintBacklogRepository.findById(sprintBacklogDto.getId()).orElseThrow(()->new RuntimeException("sprint not found "));
        sprintBacklog.setStatus(sprintBacklogDto.getStatus());
        sprintBacklogRepository.save(sprintBacklog);
    }
    //Assign tasks to developers(req : devId , Task Id)
    @Override
    public TaskDto assignTaskToDev(TaskDto taskDto){
        if (taskDto.getId() == null){
            Task taskreq=taskMapper.dtoToTask(taskDto);
            taskreq.setDeveloper(developerRepository.findById(taskDto.getDeveloperId()).orElseThrow(()->new RuntimeException("developer not found ")));
            taskreq.setScrumMaster(scrumMasterRepository.findById(taskDto.getScrumMasterId()).orElseThrow(()->new RuntimeException("scrum master not found ")));
            taskreq.setUserStory(userStoryRepository.findById(taskDto.getUserStoryId()).orElseThrow(()->new RuntimeException("user story not found ")));

            Task task =taskRepository.save(taskreq);
            return taskMapper.taskToTaskDto(task);
        }else {
            Task task=taskRepository.findById(taskDto.getId()).orElseThrow(()->new RuntimeException("task not found"));
            task.setDeveloper(developerRepository.findById(taskDto.getDeveloperId()).orElseThrow(()->new RuntimeException("developer not found ")));
            Task task2 =taskRepository.save(task);
            return taskMapper.taskToTaskDto(task2);
        }

    }

}
