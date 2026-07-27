package com.example.book.library.model.userInfo;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LastReadBookRes {
    private Long libraryId;
    private String title;
    private String thumbnail;
}
