package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.UserStoryDto;

import java.util.List;

public interface UserStoryService {

    List<UserStoryDto> getAllUserStories();

    UserStoryDto getUserStory(Long projectDtoId);

    UserStoryDto createUserStory(UserStoryDto userStoryDto);

    UserStoryDto deleteUserStory(Long userStoryId);

}