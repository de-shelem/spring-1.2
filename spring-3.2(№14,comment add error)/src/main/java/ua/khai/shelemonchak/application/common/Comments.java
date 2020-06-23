package ua.khai.shelemonchak.application.common;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comments")

public class Comments {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    User user;

    @Column(name = "data")
    private Date date;

    @ManyToOne
    private Book book;

    public Comments(String comment, User user, Book book) {
        this.comment = comment;
        this.user = user;
        this.book = book;
        this.date = new Date();
    }

    public Comments() {

    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Book getBook() {
        return book;
    }

}
