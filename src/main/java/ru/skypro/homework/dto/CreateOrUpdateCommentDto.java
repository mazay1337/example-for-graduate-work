package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Objects;

/**
 * Класс для создания или изменения комментария
 * */
@Data
public class CreateOrUpdateCommentDto {

    private String text;

}
