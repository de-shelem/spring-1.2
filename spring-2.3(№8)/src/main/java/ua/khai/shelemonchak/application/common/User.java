package ua.khai.shelemonchak.application.common;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int user_id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Comments> comments = new ArrayList<Comments>();

    public User() {

    }

    public User(String name) {
        this.name = name;
    }


}
