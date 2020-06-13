package ua.khai.shelemonchak.application.jpa.common;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")

public class Comments {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "author")
    private String author;

    public Comments(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }

    public Comments(){

    }
}
