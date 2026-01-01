package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
