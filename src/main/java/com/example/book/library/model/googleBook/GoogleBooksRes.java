package com.example.book.library.model.googleBook;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GoogleBooksRes {
    private Integer totalItems;
    private List<Item> items;
}
