package ru.skypro.homework.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return price == ad.price && Objects.equals(id, ad.id) && Objects.equals(title, ad.title) && Objects.equals(description, ad.description) && Objects.equals(author, ad.author) && Objects.equals(image, ad.image) && Objects.equals(comments, ad.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, author, image, comments);
    }
}
