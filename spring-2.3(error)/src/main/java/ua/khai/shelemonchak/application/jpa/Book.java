package ua.khai.shelemonchak.application.jpa;

import lombok.Data;
import ua.khai.shelemonchak.application.jpa.common.Comments;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "book")
public class Book {
    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;

    }

    public Book(){

    }
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "author", nullable = false, unique = true)
    private String author;
    @Column(name = "genre", nullable = false, unique = true)
    private String genre;
    @OneToMany
    private List<Comments> comments;


}
