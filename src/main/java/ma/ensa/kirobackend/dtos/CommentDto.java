package ma.ensa.kirobackend.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private String photoBase64;
    private LocalDateTime createdAt;

    // Informations de l'utilisateur
    private Long userId;
    private String userName;

    // Informations de la tâche
    private Long taskId;
}