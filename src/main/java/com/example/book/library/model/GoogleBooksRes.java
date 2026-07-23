package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GoogleBooksRes {
    private Integer totalItems;
    private List<Item> items;
}
