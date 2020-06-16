package ua.khai.shelemonchak.application.common;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Book> books = new ArrayList<Book>();

    @Column(name = "name")
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author(){

    }


}
