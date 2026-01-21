package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.ProductBacklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBacklogRepository extends JpaRepository<ProductBacklog,Long> {
}
