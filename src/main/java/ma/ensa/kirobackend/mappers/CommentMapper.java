package ma.ensa.kirobackend.mappers;


import ma.ensa.kirobackend.dtos.CommentDto;
import ma.ensa.kirobackend.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface CommentMapper {
    //Entity to Dto
    @Mapping(target="userId",source="user.id")
    @Mapping(target="userName",source="user.nom")
    @Mapping(target="taskId",source="task.id")
    @Mapping(target = "photoBase64", source = "photo")
    CommentDto commentToCommentDto(Comment comment);


    //Dto to entity
    @Mapping(target="user",ignore = true)
    @Mapping(target="task",ignore = true)
    @Mapping(target = "photo", source = "photoBase64")
    Comment dtoToComment(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> commentList);
}
