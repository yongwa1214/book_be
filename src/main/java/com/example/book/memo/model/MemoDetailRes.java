package com.example.book.memo.model;

import lombok.Getter;

@Getter
public class MemoDetailRes {
    private Integer memoId;
    private String title;
    private String content;
    private String type;
    private String createdAt;
    private String updatedAt;
}
