package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.Epic;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.entities.UserStory;
import ma.ensa.kirobackend.exceptions.UserStoryNotFoundException;
import ma.ensa.kirobackend.mappers.UserStoryMapper;
import ma.ensa.kirobackend.repository.EpicRepository;
import ma.ensa.kirobackend.repository.SprintBacklogRepository;
import ma.ensa.kirobackend.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {
    private UserStoryRepository userStoryRepository;
    private UserStoryMapper userStoryMapper;
    private EpicRepository epicRepository;
    private SprintBacklogRepository sprintBacklogRepository;

    @Override
    public List<UserStoryDto> getAllUserStories() {
        List<UserStory> userStories = userStoryRepository.findAll();
        return userStoryMapper.toDtoList(userStories);
    }

    @Override
    public UserStoryDto getUserStory(Long userStoryId) {
        UserStory userStory = userStoryRepository.findById(userStoryId)
                .orElseThrow(() -> new UserStoryNotFoundException("UserStory not found"));

        return userStoryMapper.toUserStoryDto(userStory);
    }

    @Override
    public UserStoryDto createUserStory(UserStoryDto userStoryDto) {
        UserStory userStory = userStoryMapper.dtoToUserStory(userStoryDto);

        // Set Epic if epicId is provided
        if (userStoryDto.getEpicId() != null) {
            Epic epic = epicRepository.findById(userStoryDto.getEpicId())
                    .orElseThrow(() -> new RuntimeException("Epic not found"));
            userStory.setEpic(epic);
        }

        // Set SprintBacklog if sprintBacklogId is provided
        if (userStoryDto.getSprintBacklogId() != null) {
            SprintBacklog sprintBacklog = sprintBacklogRepository.findById(userStoryDto.getSprintBacklogId())
                    .orElseThrow(() -> new RuntimeException("SprintBacklog not found"));
            userStory.setSprintBacklog(sprintBacklog);
        }

        UserStory savedUserStory = userStoryRepository.save(userStory);
        return userStoryMapper.toUserStoryDto(savedUserStory);
    }

    @Override
    public void deleteUserStory(Long userStoryId) {
        UserStory userStory = userStoryRepository.findById(userStoryId)
                .orElseThrow(() -> new UserStoryNotFoundException("UserStory not found"));

        userStoryRepository.delete(userStory);
    }
}