package com.oxford.library.BooksAPI.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
}
