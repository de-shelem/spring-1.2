package ua.khai.shelemonchak.application.common;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")

public class Comments {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int comments_id;

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
}
