package ua.khai.shelemonchak.application.rest.dto;

import lombok.Data;
import ua.khai.shelemonchak.application.common.Author;
import ua.khai.shelemonchak.application.common.Comments;

import java.util.Iterator;
@Data
public class CommentsDto {

    private int id;
    private String comment;
    private String user;
    private String date;
    private String bookName;
    private String bookAuthor;

    public CommentsDto(Comments comments) {
        this.id = comments.getId();
        this.comment = comments.getComment();
        this.user = comments.getUser().getName();
        this.date = comments.getDate().toString();
        this.bookName = comments.getBook().getName();
        Iterator<Author> authorIterable = comments.getBook().getAuthorList().iterator();
        this.bookAuthor = "";
        for (; authorIterable.hasNext(); )
            this.bookName += authorIterable.next().getName();
    }
}
