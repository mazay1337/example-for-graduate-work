package ru.skypro.homework.dto;


import lombok.Data;

import java.util.Objects;

/**
 * Класс для описания комментария к объявлению
 * */
@Data
public class CommentDto {

    private int pk;
    private String text;
    private long createdAt;
    private int author;
    private String authorImage;
    private String authorFirstName;

}
