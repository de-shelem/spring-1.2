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

    @GetMapping("/")
    public String index() {

        return "index";
    }


}
