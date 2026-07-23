package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookSearchReq {
    private String keyword;
    private String searchType;
    private Integer page = 1;
    private Integer size = 20;
}
