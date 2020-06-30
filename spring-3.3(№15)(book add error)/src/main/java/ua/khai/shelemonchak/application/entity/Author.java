package ua.khai.shelemonchak.application.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<Book>();

    @Column(name = "name")
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

    public int getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }


}
