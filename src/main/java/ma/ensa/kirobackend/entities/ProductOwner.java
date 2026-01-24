package ma.ensa.kirobackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductOwner extends User {

    @OneToMany(mappedBy = "productOwner")
    private List<Projet> projets;
}