package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Objects;

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
