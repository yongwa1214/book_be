package com.example.book.account;

import com.example.book.account.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    int save(AccountJoinReq req);
    int sameId(String loginId);
    AccountLoginRes findByLoginId(AccountLoginReq req);
}
