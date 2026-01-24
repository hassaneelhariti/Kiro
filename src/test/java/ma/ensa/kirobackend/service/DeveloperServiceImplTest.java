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
        Long devId = 1L;
        Developer developer = new Developer();
        developer.setId(devId);


        Task task1 = new Task();
        task1.setId(101L);
        Task task2 = new Task();
        task2.setId(102L);

        Comment comment1 = new Comment();
        comment1.setId(201L);
        Comment comment2 = new Comment();
        comment2.setId(202L);

        task1.setComments(List.of(comment1));
        task2.setComments(List.of(comment2));

        TaskDto taskDto1 = new TaskDto();
        taskDto1.setId(101L);
        TaskDto taskDto2 = new TaskDto();
        taskDto2.setId(102L);

        CommentDto commentDto1 = new CommentDto();
        commentDto1.setId(201L);
        CommentDto commentDto2 = new CommentDto();
        commentDto2.setId(202L);

        when(developerRepository.findById(devId)).thenReturn(Optional.of(developer));
        when(taskRepository.findAllByDeveloperId(devId)).thenReturn(List.of(task1, task2));
        when(taskMapper.taskToTaskDto(task1)).thenReturn(taskDto1);
        when(taskMapper.taskToTaskDto(task2)).thenReturn(taskDto2);
        when(commentMapper.commentToCommentDto(comment1)).thenReturn(commentDto1);
        when(commentMapper.commentToCommentDto(comment2)).thenReturn(commentDto2);

        List<TaskDto> result = developerService.allTasks(devId);

        assertEquals(2, result.size());
        assertEquals(101L, result.get(0).getId());
        assertEquals(102L, result.get(1).getId());

        assertEquals(1, result.get(0).getCommentDtos().size());
        assertEquals(201L, result.get(0).getCommentDtos().get(0).getId());
        assertEquals(1, result.get(1).getCommentDtos().size());
        assertEquals(202L, result.get(1).getCommentDtos().get(0).getId());

        verify(developerRepository).findById(devId);
        verify(taskRepository).findAllByDeveloperId(devId);
        verify(taskMapper, times(1)).taskToTaskDto(task1);
        verify(taskMapper, times(1)).taskToTaskDto(task2);
        verify(commentMapper, times(1)).commentToCommentDto(comment1);
        verify(commentMapper, times(1)).commentToCommentDto(comment2);
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
