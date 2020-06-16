package ua.khai.shelemonchak.application.common;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Comments> comments = new ArrayList<Comments>();

    public User(){

    }

    public User(String name) {
        this.name = name;
        }


}
