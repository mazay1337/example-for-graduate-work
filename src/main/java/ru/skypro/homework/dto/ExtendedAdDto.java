package ru.skypro.homework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ExtendedAdDto {

    @Schema(description = "id объявления")
    private int pk;

    @Schema(description = "заголовок объявления")
    private String title;

    @Schema(description = "описание объявления")
    private String description;

    @Schema(description = "цена объявления")
    private int price;

    @Schema(description = "ссылка на картинку объявления")
    private String image;

    @Schema(description = "имя автора объявления")
    private String authorFirstName;

    @Schema(description = "фамилия автора объявления")
    private String authorLastName;

    @Schema(description = "логин автора объявления")
    private String email;

    @Schema(description = "телефон автора объявления")
    private String phone;
}
