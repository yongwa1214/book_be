package com.example.book.library.model.userInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class MonthBookList {
    private Integer memberId;
    private LocalDate start;
    private LocalDate end;
}
