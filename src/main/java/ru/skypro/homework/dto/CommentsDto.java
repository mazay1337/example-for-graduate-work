package ru.skypro.homework.dto;


import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * Класс, предсталяющий общее колличество комментариев
 * */
@Data
public class CommentsDto {

    private int type;
    private List<CommentDto> results;

}
