package com.oxford.library.BooksAPI.controller;

import com.oxford.library.BooksAPI.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/books")
public class BooksAPIController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book has been added in library";
    }

    @GetMapping("/getBook/{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") int bookId) {
        Optional<Book> result = books.stream().parallel().filter(book -> book.getBookId() == bookId).findAny();
        return result;
    }

    @PutMapping("/editBook/{bookId}")
    public String editBookById(@PathVariable("bookId") int bookId, @RequestBody Book book) {

        books = books.stream().map(bookInArray -> {
            if(bookInArray.getBookId() == bookId){
                bookInArray.setBookId(book.getBookId());
                bookInArray.setAuthorName(book.getAuthorName());
                bookInArray.setBookName(book.getBookName());
            }return bookInArray;
        }).collect(Collectors.toList());

        return "Book updated successfully";
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBookById(@PathVariable("bookId") int bookId) {

        books = books.stream().filter(bookInArray ->
            bookInArray.getBookId() != bookId
        ).collect(Collectors.toList());

        return "Book deleted successfully";
    }
}
