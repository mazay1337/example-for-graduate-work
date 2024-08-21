package ru.skypro.homework.dto;


import lombok.Data;

import java.util.List;

/**
 * Класс, предсталяющий общее колличество комментариев
 * */
@Data
public class CommentsDto {

    private int type;
    private List<CommentDto> results;

}
