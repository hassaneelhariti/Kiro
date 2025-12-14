package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByDeveloperId(Long devId);
}
