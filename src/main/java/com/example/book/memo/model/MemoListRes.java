package com.example.book.memo.model;

import lombok.Getter;

@Getter
public class MemoListRes {
    private Integer memoId;
    private Integer libraryId;
    private String title;
    private String updatedAt;
}
