package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory,Long> {
}
