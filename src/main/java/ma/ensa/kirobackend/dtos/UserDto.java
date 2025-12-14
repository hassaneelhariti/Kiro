package ma.ensa.kirobackend.dtos;


import lombok.Data;


@Data
public abstract class UserDto {
    private Long id;
    private String nom;
    private String email;

}