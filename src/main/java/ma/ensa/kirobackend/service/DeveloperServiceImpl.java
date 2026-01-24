package ma.ensa.kirobackend.service;


import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.dtos.ProjetDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.*;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.exceptions.TaskNotFoundException;
import ma.ensa.kirobackend.exceptions.UserNotFoundException;
import ma.ensa.kirobackend.mappers.CommentMapper;
import ma.ensa.kirobackend.mappers.TaskMapper;
import ma.ensa.kirobackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService{
    private TaskRepository taskRepository;
    private DeveloperRepository developerRepository;
    private ScrumMasterRepository scrumMasterRepository;
    private UserStoryRepository userStoryRepository;
    private TaskMapper taskMapper;
    private CommentMapper commentMapper;
    private CommentRepository commentRepository;

    @Override
    public List<TaskDto> allTasks(Long devId){
        Developer developer=developerRepository.findById(devId).orElse(null);
        if(developer==null) throw new UserNotFoundException("Developer not Found");

        List<Task> devTasks=taskRepository.findAllByDeveloperId(developer.getId());
        List<TaskDto> devTasksDto=taskMapper.toDtoList(devTasks);


        return devTasksDto;
    }
    @Override
    public TaskDto updateTaskStatus(Long taskId, TaskStatus taskStatus){
        Task task=taskRepository.findById(taskId).orElse(null);
        if(task==null) throw new TaskNotFoundException("Task not Found");

        task.setStatus(taskStatus);
        Task task1=taskRepository.save(task);
        return taskMapper.taskToTaskDto(task1);
    }

    //Consulter ses projets
    @Override
    public List<ProjetDto> viewProjects(Long devId){
        List<Projet> projetList=developerRepository.findDeveloperById(devId);
        List<ProjetDto> projetDtoList= new ArrayList<>();
        for (Projet projet :projetList){

        }
        return projetDtoList;
    }
    // create new task by a developer auto assigned
    @Override
    public TaskDto createNewTask(TaskDto taskDto) {

        Task task = taskMapper.dtoToTask(taskDto);

        task.setDeveloper(
                developerRepository.findById(taskDto.getDeveloperId())
                        .orElseThrow(() -> new RuntimeException("Developer not found"))
        );

        task.setScrumMaster(
                scrumMasterRepository.findById(taskDto.getScrumMasterId())
                        .orElseThrow(() -> new RuntimeException("ScrumMaster not found"))
        );


        task.setUserStory(
                userStoryRepository.findById(taskDto.getUserStoryId())
                        .orElseThrow(() -> new RuntimeException("UserStory not found"))
        );

        Task savedTask = taskRepository.save(task);

        return taskMapper.taskToTaskDto(savedTask);
    }


    // developer comment on exact post
    @Override
    public CommentDto commentOnTask(CommentDto commentDto){
        Comment comment=commentMapper.dtoToComment(commentDto);
        Task task=taskRepository.findById(commentDto.getTaskId()).orElseThrow(()-> new RuntimeException( "task for comment not found"));
        User user=developerRepository.findById(commentDto.getUserId())
                .orElseThrow(() -> new RuntimeException("UserStory not found"));
        comment.setTask(task);
        comment.setUser(user);
        Comment comment1=commentRepository.save(comment);
        return commentMapper.commentToCommentDto(comment1);
    }



}
