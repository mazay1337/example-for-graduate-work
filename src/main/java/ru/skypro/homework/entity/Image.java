package ru.skypro.homework.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long fileSize;
    private String mediaType;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return fileSize == image.fileSize && Objects.equals(id, image.id) && Objects.equals(mediaType, image.mediaType) && Objects.deepEquals(data, image.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileSize, mediaType, Arrays.hashCode(data));
    }
}
