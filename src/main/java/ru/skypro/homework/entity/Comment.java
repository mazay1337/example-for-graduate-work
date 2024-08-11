package ru.skypro.homework.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createAt;
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

}
