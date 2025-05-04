package com.example.ebookyoop.contoller;

import com.example.ebookyoop.model.Book;
import com.example.ebookyoop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    BookService service;

    public BookController(){
        service = new BookService();
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getAllBook();
    }
}
