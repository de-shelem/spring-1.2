package ua.khai.shelemonchak.application.dto;

import lombok.Data;
import ua.khai.shelemonchak.application.entity.Author;
import ua.khai.shelemonchak.application.entity.Comments;

import java.util.Iterator;

@Data
public class CommentsDto {

    private int id;
    private String text;
    private String username;
    private String date;


    public CommentsDto(Comments comments) {
        this.id = comments.getId();
        this.text = comments.getComment();
        this.username = comments.getUser().getName();
        this.date = comments.getDate().toString();
    }
}
