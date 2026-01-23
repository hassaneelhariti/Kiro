package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.UserStoryDto;
import ma.ensa.kirobackend.service.productownerservice.UserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user-story")
public class UserStoryController {
    private UserStoryService userStoryService;

    @GetMapping
    public ResponseEntity<List<UserStoryDto>> getAllUserStories() {
        List<UserStoryDto> userStories = userStoryService.getAllUserStories();
        return ResponseEntity.ok(userStories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserStoryDto> getUserStory(@PathVariable Long id) {
        UserStoryDto userStory = userStoryService.getUserStory(id);
        return ResponseEntity.ok(userStory);
    }

    @PostMapping
    public ResponseEntity<UserStoryDto> createUserStory(@Valid @RequestBody UserStoryDto userStoryDto) {
        UserStoryDto createdUserStory = userStoryService.createUserStory(userStoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserStory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserStoryDto> deleteUserStory(@PathVariable Long id) {
        UserStoryDto deletedUserStory = userStoryService.deleteUserStory(id);
        return ResponseEntity.ok(deletedUserStory);
    }
}