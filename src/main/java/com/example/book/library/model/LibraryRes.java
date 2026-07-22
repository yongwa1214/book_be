package com.example.book.library.model;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class LibraryRes {
    private Integer libraryId;
    private String bookName;
    private String status;
}
