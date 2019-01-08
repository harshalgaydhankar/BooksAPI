package com.oxford.library.BooksAPI.controller;

import com.oxford.library.BooksAPI.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BooksAPIController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return books;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        books.add(book);
        return "Book has been added in library";
    }
}
