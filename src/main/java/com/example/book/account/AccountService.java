package com.example.book.account;

import com.example.book.account.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountMapper accountMapper;

    public int join(AccountJoinReq req){
        log.info("req = {}", req);
        String hashedPw = BCrypt.hashpw(req.getLoginPw(), BCrypt.gensalt()); // pw　暗号化
        log.info(hashedPw);
        AccountJoinReq changedReq = AccountJoinReq.builder()
                .loginId(req.getLoginId())
                .loginPw(hashedPw)
                .name(req.getName())
                .build();

        return accountMapper.save(changedReq);
    }

    public AccountLoginRes login(AccountLoginReq req){
        AccountLoginRes res = accountMapper.findByLoginId(req);
        // // 아이디가 없거나 비밀번호가 다르다면
        if(res == null || !BCrypt.checkpw(req.getLoginPw(), res.getLoginPw())){ // .checkpw 첫번째: 받은 비번 두번째: db에 있는 암호화된 비번
            return null; // return null; 처리
        }

        return res;
    }
}
