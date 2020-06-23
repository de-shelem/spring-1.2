package ua.khai.shelemonchak.application.common;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    String nameOfGenre;

    public Genre(String nameOfGanre) {
        this.nameOfGenre = nameOfGanre;
    }

    public Genre() {

    }
    public int getId() {
        return id;
    }

    public String getNameOfGenre() {
        return nameOfGenre;
    }

}
