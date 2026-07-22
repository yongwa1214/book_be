package com.example.book.library.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class LibraryReq {
    private Integer memberId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int page;
    private String status;
    private String bookName;
}
