package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BookSearchItem {
    private String id;

    private String title;

    private List<String> authors;

    private String publisher;

    private String publishedDate;

    private String description;

    private Integer pageCount;

    private String thumbnail;
}
