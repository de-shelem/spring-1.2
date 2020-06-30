package ua.khai.shelemonchak.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.khai.shelemonchak.application.dto.BookDto;
import ua.khai.shelemonchak.application.entity.Book;
import ua.khai.shelemonchak.application.services.BookDepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class BookDepositoryRestController {

    @Autowired
    private BookDepository bookDepository;
/////////////////////////////////////
    /////////////////////////////////////
    /////////////////////////////////////

    @RequestMapping("/getlist")
    public List<BookDto> getBooks() {
        List<Book> books = bookDepository.getAllBooks();
        List<BookDto> bookDtos = books
                .stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
        return bookDtos;
    }

    /////////////////////////////////////
    /////////////////////////////////////
    /////////////////////////////////////
    @RequestMapping(value = "/addbook",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Book addBook(@RequestBody BookDto bookDto) {
        return bookDepository.addBook(bookDto);
    }

    @RequestMapping(value = "/deleteBook/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") int id) {
        bookDepository.deleteBookById(id);
    }


}