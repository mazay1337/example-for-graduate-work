package ru.skypro.homework.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Comment;

public interface CommentMapper {


    CommentMapper INSANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "authorFirstName", source = "author")
    CommentDto commentToCommentDto(Comment comment);

    Comment CommentDtoToComment(CommentDto commentDto);

    CreateOrUpdateCommentDto CommentToCreateOrUpdateCommentDto(Comment comment);

    Comment createOrUpdateCommentDtoToComment(CreateOrUpdateCommentDto createOrUpdateCommentDto);
}
