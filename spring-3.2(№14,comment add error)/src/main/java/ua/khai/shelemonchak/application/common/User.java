package ua.khai.shelemonchak.application.common;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Comments> comments = new ArrayList<Comments>();

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Comments> getComments() {
        return comments;
    }

}
