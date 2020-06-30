package ua.khai.shelemonchak.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.khai.shelemonchak.application.dto.CommentsDto;
import ua.khai.shelemonchak.application.entity.Comments;
import ua.khai.shelemonchak.application.services.BookDepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentsRestController {

    @Autowired
    BookDepository bookDepository;

    @RequestMapping(value ="/getComments/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public List<CommentsDto> getComments(@PathVariable("id")int id) {
        List<Comments> comments = bookDepository.findAllCommentByBookId(id);
        List<CommentsDto> commentsDtos = comments
                .stream()
                .map(CommentsDto::new)
                .collect(Collectors.toList());


        return commentsDtos;
    }

    @RequestMapping(value = "/deleteComment/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBook(@PathVariable("id") int id) {
        bookDepository.deleteCommentsById(id);
    }
}
