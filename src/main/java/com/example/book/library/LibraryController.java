package com.example.book.library;

import com.example.book.account.etc.AccountConstants;
import com.example.book.common.util.HttpUtils;
import com.example.book.library.model.BookSearchList;
import com.example.book.library.model.BookSearchReq;
import com.example.book.library.model.LibraryReq;
import jakarta.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("bobo")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/save-book")
    public ResponseEntity<?> saveBook(@RequestBody LibraryReq req, HttpServletRequest httpReq){
        Integer memberId =(Integer) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        libraryService.bookSave(memberId, req);
        return ResponseEntity.ok("good");
    }

    @GetMapping
    public BookSearchList bookList(BookSearchReq searchReq){}
}
