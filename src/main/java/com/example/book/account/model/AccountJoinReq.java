package com.example.book.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Builder
@Getter
@Slf4j
public class AccountJoinReq {
    private String name;
    private String loginId;
    private String loginPw;
}
