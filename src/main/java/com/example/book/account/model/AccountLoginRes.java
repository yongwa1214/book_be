package com.example.book.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class AccountLoginRes {
    private int memberId;
    private String name;

    @JsonIgnore
    private String loginPw;
}
