package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic,Long> {
}
