package ua.khai.shelemonchak.application.common;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int genre_id;

    String nameOfGenre;

    public Genre(String nameOfGanre) {
        this.nameOfGenre = nameOfGanre;
    }

    public Genre() {

    }


}
