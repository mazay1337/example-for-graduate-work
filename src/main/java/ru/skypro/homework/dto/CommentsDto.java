package ru.skypro.homework.dto;


import java.util.List;
import java.util.Objects;

/**
 * Класс, предсталяющий общее колличество комментариев
 * */
public class CommentsDto {

    private int type;
    private List<CommentDto> results;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CommentDto> getResults() {
        return results;
    }

    public void setResults(List<CommentDto> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsDto that = (CommentsDto) o;
        return type == that.type && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, results);
    }

    @Override
    public String toString() {
        return "CommentsDto{" +
                "type=" + type +
                ", results=" + results +
                '}';
    }
}
