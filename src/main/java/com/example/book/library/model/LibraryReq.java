package com.example.book.library.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class LibraryReq {
    private Integer memberId;
    private String status;
    private String bookName;
}
