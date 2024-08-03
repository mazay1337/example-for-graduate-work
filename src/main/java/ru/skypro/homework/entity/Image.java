package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imageDir;
    private String fileType;
    private String fileName;
    private String fileExtension;
    private long fileSize;

    public Path getFilePath() {
        return Paths.get(this.getImageDir(), this.getId() + "." + this.getFileExtension());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id && fileSize == image.fileSize && Objects.equals(imageDir, image.imageDir) && Objects.equals(fileType, image.fileType) && Objects.equals(fileName, image.fileName) && Objects.equals(fileExtension, image.fileExtension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageDir, fileType, fileName, fileExtension, fileSize);
    }
}
