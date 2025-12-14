package ma.ensa.kirobackend.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductOwner extends User{



    @OneToMany(mappedBy = "productOwner")
    List<Projet> projets;
}
