package ru.skypro.homework.dto;


import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * Класс, представляющий все объявления
 * */
@Data
public class AdsDto {

    private int count;
    private List<AdDto> results;

}
