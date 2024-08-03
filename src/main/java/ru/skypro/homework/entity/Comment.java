package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createdAt;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(createdAt, comment.createdAt) && Objects.equals(text, comment.text) && Objects.equals(author, comment.author) && Objects.equals(ad, comment.ad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, text, author, ad);
    }
}
