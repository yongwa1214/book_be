package com.example.book.memo.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemoReq {
    private Integer memoId;
    private Integer libraryId;
    private String title;
    private String content;
    private String type;

}
