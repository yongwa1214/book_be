package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookSearchReq {

    private String keyword;
    private String type;
    private Integer page;

}
