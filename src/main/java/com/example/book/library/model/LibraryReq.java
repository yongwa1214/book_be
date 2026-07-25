package com.example.book.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryReq {
    private Integer libraryId;
    private Integer memberId;
    private String bookId; // book_id
    private String title;
    private String authors;
    private String publisher;
    private String publishedDate;
    private String thumbnail;
    private String summary;
    private Integer totalPage;
    private Integer readPage;
    private String status;

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}

