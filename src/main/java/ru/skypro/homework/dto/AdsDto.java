package ru.skypro.homework.dto;


import java.util.List;
import java.util.Objects;

/**
 * Класс, представляющий все объявления
 * */
public class AdsDto {

    private int count;
    private List<AdDto> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AdDto> getResults() {
        return results;
    }

    public void setResults(List<AdDto> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdsDto adsDto = (AdsDto) o;
        return count == adsDto.count && Objects.equals(results, adsDto.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, results);
    }

    @Override
    public String toString() {
        return "AdsDto{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
