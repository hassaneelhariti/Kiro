package ma.ensa.kirobackend.repository;

import ma.ensa.kirobackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
