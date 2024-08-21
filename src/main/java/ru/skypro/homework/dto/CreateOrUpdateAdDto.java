package ru.skypro.homework.dto;


import lombok.Data;


/**
 * Класс для создания или изменения объявления
 * */
@Data
public class CreateOrUpdateAdDto {

    private String title;
    private String description;
    private int price;

}
