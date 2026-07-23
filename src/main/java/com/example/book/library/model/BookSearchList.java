package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookSearchList {
    private List<BookSearchItem> results;
    private Integer page;
    private Integer size;
    private Integer totalCount;
}
