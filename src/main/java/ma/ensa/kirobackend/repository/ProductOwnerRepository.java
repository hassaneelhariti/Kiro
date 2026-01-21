package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Epic;
import ma.ensa.kirobackend.entities.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOwnerRepository extends JpaRepository<ProductOwner,Long> {

}
