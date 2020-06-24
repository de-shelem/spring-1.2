package ua.khai.shelemonchak.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.khai.shelemonchak.application.dto.BookDto;
import ua.khai.shelemonchak.application.dto.CommentsDto;
import ua.khai.shelemonchak.application.entity.Book;
import ua.khai.shelemonchak.application.entity.Comments;
import ua.khai.shelemonchak.application.services.BookDepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookDepositoryController {

    @Autowired
    private BookDepository bookDepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookDepository.getAllBooks();
        List<BookDto> bookDtos = books
                .stream()
                .map(BookDto::new)
                .collect(Collectors.toList());

        model.addAttribute("books", bookDtos);
        return "index";
    }

    @PostMapping("/add")
    public String addNewBook(@RequestParam(name = "authors") String authors,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "genre") String genre,
                             Model model) {

        Book book = bookDepository.addBook(name, genre, authors);
        model.addAttribute("addResult", book != null);
        return "redirect:/";
    }

    @GetMapping("/add-comment")
    public String addComments(@RequestParam(name = "id") int id, Model model) {
        Book book = bookDepository.findBookById(id);
        model.addAttribute("book", new BookDto(book));
        return "add-comment";
    }

    @GetMapping("add-new-comment")
    public String addNewComment(
            @RequestParam(name = "comment") String comment,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "id") int id,
            Model model
    ) {
        Comments comments = bookDepository.addCommentByBookId(id, comment, username);
        model.addAttribute("comment", comments);
        return "redirect:/";
    }

    @GetMapping("/comment")
    public String showCommentsByBookId(@RequestParam(name = "id") int id, Model model) {
        List<Comments> comments = bookDepository.findAllCommentByBookId(id);
        List<CommentsDto> commentsDtos = comments
                .stream()
                .map(CommentsDto::new)
                .collect(Collectors.toList());
        System.out.println(commentsDtos);
        model.addAttribute("comments", commentsDtos);
        return "comment";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam(name = "id") int id) {
        bookDepository.deleteBookById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showBookForEdit(@RequestParam(name = "id") int id, Model model) {
        Book book = bookDepository.findBookById(id);
        model.addAttribute("book", new BookDto(book));
        return "edit";
    }

    @GetMapping("/update")
    public String updateBook(@RequestParam(name = "name") String name,
                             @RequestParam(name = "id") int id,
                             Model model) {
        bookDepository.updateBookNameById(id, name);
        Book book = bookDepository.findBookById(id);
        model.addAttribute("book", new BookDto(book));
        return "redirect:/";
    }


}
