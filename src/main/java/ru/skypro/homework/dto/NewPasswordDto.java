package ru.skypro.homework.dto;

import lombok.Data;


/**
 * Класс для изменения пароля пользователя
 * */
@Data
public class NewPasswordDto {

    private String currentPassword;
    private String newPassword;

}
