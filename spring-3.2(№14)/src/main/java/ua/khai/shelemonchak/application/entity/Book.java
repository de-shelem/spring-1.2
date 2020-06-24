package ua.khai.shelemonchak.application.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    public Book() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = false)
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;


    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comments> comments = new ArrayList<Comments>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authorList;


    public Book(String name, Genre genre, Set<Author> authorList) {
        this.name = name;
        this.genre = genre;
        this.authorList = authorList;
    }

    public void addComment(Comments comments) {
        this.comments.add(comments);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public Set<Author> getAuthorList() {
        return authorList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nid=" + id +
                ",\n name='" + name + '\'' +
                ",\n genre=" + genre +
                ",\n comments= [" + (comments != null ? comments.size() : null) +
                "],\n authorList=" + (authorList != null ? authorList.size() : "null") +
                "\n}";
    }
}
