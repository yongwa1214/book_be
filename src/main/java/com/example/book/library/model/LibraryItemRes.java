package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LibraryItemRes {
    private Integer libraryId;
    private String id; // book_id
    private String title;
    private String authors;
    private String publisher;
    private String publishedDate;
    private String thumbnail;
    private String summary;
    private Integer totalPage;
    private Integer readPage;
    private String status;
}
