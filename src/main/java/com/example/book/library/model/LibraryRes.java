package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LibraryRes {
    private Integer libraryId;
    private String id; // book_id
    private String title;
    private String thumbnail;
    private String status;
}
