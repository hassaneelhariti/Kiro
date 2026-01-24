package ma.ensa.kirobackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.dtos.TaskDto;
import ma.ensa.kirobackend.entities.Comment;
import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.Task;
import ma.ensa.kirobackend.enums.TaskStatus;
import ma.ensa.kirobackend.exceptions.TaskNotFoundException;
import ma.ensa.kirobackend.exceptions.UserNotFoundException;
import ma.ensa.kirobackend.mappers.CommentMapper;
import ma.ensa.kirobackend.mappers.TaskMapper;
import ma.ensa.kirobackend.repository.DeveloperRepository;
import ma.ensa.kirobackend.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private DeveloperServiceImpl developerService;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllTasks_returnsTasksWithComments() {
        // Developer
        Long devId = 1L;
        Developer developer = new Developer();
        developer.setId(devId);

        // Tasks
        Task task1 = new Task();
        task1.setId(101L);
        Task task2 = new Task();
        task2.setId(102L);

        // Comments
        Comment comment1 = new Comment();
        comment1.setId(201L);
        comment1.setTask(task1);
        comment1.setUser(developer);

        Comment comment2 = new Comment();
        comment2.setId(202L);
        comment2.setTask(task2);
        comment2.setUser(developer);

        task1.setComments(List.of(comment1));
        task2.setComments(List.of(comment2));

        // Task DTOs with nested comment DTOs
        TaskDto taskDto1 = new TaskDto();
        taskDto1.setId(101L);
        CommentDto commentDto1 = new CommentDto();
        commentDto1.setId(201L);
        commentDto1.setTaskId(101L);
        commentDto1.setUserId(1L);
        commentDto1.setUserName("Dev One");
        taskDto1.setCommentDtos(List.of(commentDto1));

        TaskDto taskDto2 = new TaskDto();
        taskDto2.setId(102L);
        CommentDto commentDto2 = new CommentDto();
        commentDto2.setId(202L);
        commentDto2.setTaskId(102L);
        commentDto2.setUserId(1L);
        commentDto2.setUserName("Dev One");
        taskDto2.setCommentDtos(List.of(commentDto2));

        // Mock repository calls
        when(developerRepository.findById(devId)).thenReturn(Optional.of(developer));
        when(taskRepository.findAllByDeveloperId(devId)).thenReturn(List.of(task1, task2));

        // Mock mapper call for toDtoList
        when(taskMapper.toDtoList(List.of(task1, task2)))
                .thenReturn(List.of(taskDto1, taskDto2));

        // Call service
        List<TaskDto> result = developerService.allTasks(devId);

        // Assertions
        assertEquals(2, result.size());

        assertEquals(101L, result.get(0).getId());
        assertEquals(1, result.get(0).getCommentDtos().size());
        assertEquals(201L, result.get(0).getCommentDtos().get(0).getId());

        assertEquals(102L, result.get(1).getId());
        assertEquals(1, result.get(1).getCommentDtos().size());
        assertEquals(202L, result.get(1).getCommentDtos().get(0).getId());

        // Verify repository and mapper interactions
        verify(developerRepository).findById(devId);
        verify(taskRepository).findAllByDeveloperId(devId);
        verify(taskMapper).toDtoList(List.of(task1, task2));
    }

    @Test
    void testAllTasks_throwsExceptionWhenDeveloperNotFound() {
        Long devId = 1L;

        when(developerRepository.findById(devId)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                () -> developerService.allTasks(devId));

        assertEquals("Developer not Found", exception.getMessage());

        verify(developerRepository).findById(devId);
        verifyNoMoreInteractions(taskRepository, taskMapper, commentMapper);
    }

    @Test
    void updateTaskStatus_success() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setStatus(TaskStatus.IN_PROGRESS);

        Task updatedTask = new Task();
        updatedTask.setId(taskId);
        updatedTask.setStatus(TaskStatus.DONE);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskId);
        taskDto.setStatus(TaskStatus.DONE);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);
        when(taskMapper.taskToTaskDto(updatedTask)).thenReturn(taskDto);

        TaskDto result = developerService.updateTaskStatus(taskId, TaskStatus.DONE);

        assertNotNull(result);
        assertEquals(TaskStatus.DONE, result.getStatus());

        verify(taskRepository).findById(taskId);
        verify(taskRepository).save(task);
        verify(taskMapper).taskToTaskDto(updatedTask);
    }

    @Test
    void updateTaskStatus_taskNotFound() {
        Long taskId = 1L;

        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class,
                () -> developerService.updateTaskStatus(taskId, TaskStatus.DONE));

        assertEquals("Task not Found", exception.getMessage());

        verify(taskRepository).findById(taskId);
        verify(taskRepository, never()).save(any());
        verify(taskMapper, never()).taskToTaskDto(any());
    }
}
