package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.service.productownerservice.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserStoryController {
    private UserStoryService userStoryService;

    @GetMapping("/user-story")
    public List<UserStoryDto> getAllUserStories() {
        return userStoryService.getAllUserStories();
    }

    @GetMapping("/user-story/{id}")
    public UserStoryDto getUserStory(@PathVariable Long id) {
        return userStoryService.getUserStory(id);
    }

    @PostMapping("/user-story")
    public UserStoryDto createUserStory(@Valid @RequestBody UserStoryDto userStoryDto) {
        return userStoryService.createUserStory(userStoryDto);
    }

    @DeleteMapping("/user-story/{id}")
    public void deleteUserStory(@PathVariable Long id) {
        userStoryService.deleteUserStory(id);
    }
}