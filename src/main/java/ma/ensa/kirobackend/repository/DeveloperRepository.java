package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Developer;
import ma.ensa.kirobackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {

}
