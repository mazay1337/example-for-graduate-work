package ru.skypro.homework.dto;

import java.util.Objects;

public class AdDto {

    private int pk;
    private String title;
    private int price;
    private String image;
    private int author;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdDto adDto = (AdDto) o;
        return pk == adDto.pk && price == adDto.price && author == adDto.author && Objects.equals(title, adDto.title) && Objects.equals(image, adDto.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, title, price, image, author);
    }

    @Override
    public String toString() {
        return "AdDto{" +
                "pk=" + pk +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", author=" + author +
                '}';
    }
}
