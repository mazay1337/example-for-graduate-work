package ru.skypro.homework.dto;


import java.util.Objects;

/**
 * Класс для описания комментария к объявлению
 * */
public class CommentDto {

    private int pk;
    private String text;
    private long createdAt;
    private int author;
    private String authorImage;
    private String authorFirstName;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return pk == that.pk && createdAt == that.createdAt && author == that.author && Objects.equals(text, that.text) && Objects.equals(authorImage, that.authorImage) && Objects.equals(authorFirstName, that.authorFirstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, text, createdAt, author, authorImage, authorFirstName);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "pk=" + pk +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", author=" + author +
                ", authorImage='" + authorImage + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                '}';
    }
}
