package ru.skypro.homework.dto;

import java.util.Objects;

/**
 * Класс для создания или изменения комментария
 * */
public class CreateOrUpdateCommentDto {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrUpdateCommentDto that = (CreateOrUpdateCommentDto) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }

    @Override
    public String toString() {
        return "CreateOrUpdateCommentDto{" +
                "text='" + text + '\'' +
                '}';
    }
}
