package ru.skypro.homework.dto;

import lombok.Data;



/**
 * Класс для описания объявления
 * */
@Data
public class AdDto {

    private int pk;
    private String title;
    private int price;
    private String image;
    private int author;

}
