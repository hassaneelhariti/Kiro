package ma.ensa.kirobackend.mappers;


import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface CommentMapper {
    //Entity to Dto
    @Mapping(target="userId",source="user.id")
    @Mapping(target="userName",source="user.nom")
    @Mapping(target="taskId",source="task.id")
    CommentDto commentToCommentDto(Comment comment);


    //Dto to entity
    @Mapping(target="user",ignore = true)
    @Mapping(target="task",ignore = true)
    Comment dtoToComment(CommentDto commentDto);

}
