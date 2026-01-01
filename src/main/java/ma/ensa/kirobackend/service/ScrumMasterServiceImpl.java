package ma.ensa.kirobackend.service;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.*;
import ma.ensa.kirobackend.mappers.SprintBacklogMapper;
import ma.ensa.kirobackend.mappers.TaskMapper;
import ma.ensa.kirobackend.mappers.UserStoryMapper;
import ma.ensa.kirobackend.repository.EpicRepository;
import ma.ensa.kirobackend.repository.ProjetRepository;
import ma.ensa.kirobackend.repository.SprintBacklogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScrumMasterServiceImpl implements ScrumMasterService{
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

}
