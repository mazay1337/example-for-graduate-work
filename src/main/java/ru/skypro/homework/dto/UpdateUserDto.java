package ru.skypro.homework.dto;


import lombok.Data;

import java.util.Objects;

/**
 * Класс для изменения данных пользователя
 * */
@Data
public class UpdateUserDto {

    private String firstName;
    private String lastName;
    private String phone;

}
