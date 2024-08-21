package ru.skypro.homework.dto;

import lombok.Data;


/**
 * Класс, предоставляющий расширенную информацию об объявлении
 * */
@Data
public class ExtendedAdDto {

    private int pk;
    private String title;
    private String description;
    private int price;
    private String image;
    private String authorFirstName;
    private String authorLastName;
    private String email;
    private String phone;

}
