package com.example.book.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MemoReq {
    private Integer libraryId;
    private Integer memoId;
    private String title;
    private String content;
    private String type;

}
