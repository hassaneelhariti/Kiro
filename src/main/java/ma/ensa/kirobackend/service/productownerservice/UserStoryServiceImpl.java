package ma.ensa.kirobackend.service.productownerservice;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.entities.UserStory;
import ma.ensa.kirobackend.mappers.UserStoryMapper;
import ma.ensa.kirobackend.repository.EpicRepository;
import ma.ensa.kirobackend.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {

    private UserStoryRepository userStoryRepository;
    private final EpicRepository epicRepository;
    private final UserStoryMapper userStoryMapper;

    @Override
    public UserStoryDto getUserStory(Long projectDtoId) {
        UserStory userStory = userStoryRepository.getOne(projectDtoId);
        return userStoryMapper.toUserStoryDto(userStory);
    }

    @Override
    public UserStoryDto createUserStory(UserStoryDto userStoryDto) {
return null;
    }

    @Override
    public void deleteUserStory(Long userStoryId) {

    }
}
