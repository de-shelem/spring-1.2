package ua.khai.shelemonchak.application.rest.dto;

import lombok.Data;
import ua.khai.shelemonchak.application.common.Author;
import ua.khai.shelemonchak.application.common.Book;
import ua.khai.shelemonchak.application.common.Comments;

import java.util.Iterator;
import java.util.List;

@Data
public class BookDto {
    private int id;
    private String name;
    private String genre;
    private String author;

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.genre = book.getGenre().getNameOfGenre();
        Iterator<Author> authorIterable = book.getAuthorList().iterator();
        this.author = "";
        for (; authorIterable.hasNext(); ) {
            this.author += authorIterable.next().getName();
        }
    }


}
