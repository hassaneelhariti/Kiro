package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.UserStoryDto;

public interface UserStoryService {

    UserStoryDto getUserStory(Long projectDtoId);

    UserStoryDto createUserStory(UserStoryDto userStoryDto);

    void  deleteUserStory(Long userStoryId);

}
