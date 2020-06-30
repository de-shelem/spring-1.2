package ua.khai.shelemonchak.application.dto;

import lombok.Data;
import ua.khai.shelemonchak.application.entity.Author;
import ua.khai.shelemonchak.application.entity.Book;

import java.util.Iterator;

@Data
public class BookDto {
    private int id;
    private String name;
    private String genre;
    private String author;

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }



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
