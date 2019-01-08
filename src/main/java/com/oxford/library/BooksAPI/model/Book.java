package com.oxford.library.BooksAPI.model;

import lombok.*;

@Data
public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
}
