package com.example.book.account;

import com.example.book.account.etc.AccountConstants;
import com.example.book.account.model.*;
import com.example.book.common.util.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/bobo/account")
public class AccountController {
    private final AccountService accountService;


    @PostMapping("/join") // ok
    public ResponseEntity<?> join(@RequestBody AccountJoinReq req){
        if(!StringUtils.hasLength(req.getName())
                || !StringUtils.hasLength(req.getLoginId())
                || !StringUtils.hasLength(req.getLoginPw())){// static 메소드 객체생성 안하고 바로
            return ResponseEntity.badRequest().build(); // state: 400
        }

        int result = accountService.join(req);
        return ResponseEntity.ok(result); // state: 200
    }

    @PostMapping("/login") //ok
    public ResponseEntity<?> login(HttpServletRequest httpReq, @RequestBody AccountLoginReq req){
        AccountLoginRes result = accountService.login(req);

        if(result == null){
            return ResponseEntity.notFound().build();
        }
        //세션 처리
        HttpUtils.setSession(httpReq, AccountConstants.MEMBER_ID_NAME, result.getMemberId());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest httpReq){

        Integer id =(Integer)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        log.info("id:{}",id);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest httpReq){
        HttpUtils.removeSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        return ResponseEntity.ok(1);
    }
}
