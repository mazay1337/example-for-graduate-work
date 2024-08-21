package ru.skypro.homework.dto;

import lombok.Data;

/**
 * Класс, представляющий логин пользователя
 * */
@Data
public class LoginDto {

    private String username;
    private String password;

}
