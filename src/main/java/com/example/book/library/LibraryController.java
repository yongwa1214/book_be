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
@RequestMapping("api/bobo")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/save-book")
    public ResponseEntity<?> saveBook(@RequestBody LibraryReq req, HttpServletRequest httpReq){
        Integer memberId =(Integer) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        libraryService.bookSave(memberId, req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/book")
    public ResponseEntity<?> bookList(BookSearchReq searchReq){

        return ResponseEntity.ok(libraryService.bookSearch(searchReq));
    }

    @GetMapping("my/library")
    public ResponseEntity<?> myBookList(HttpServletRequest httpReq){
        Integer memberId =(Integer) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        return ResponseEntity.ok(libraryService.myBookList(memberId));
    }

    @GetMapping("my/book/{libraryId}") //id -> library_id
    public ResponseEntity<?> myBookItem(@PathVariable Long libraryId){
        return ResponseEntity.ok(libraryService.myBookItem(libraryId));
    }

    @PutMapping("/my/book")
    public ResponseEntity<?>bookUpdate(@RequestBody LibraryReq req){
        libraryService.bookUpdate(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{libraryId}")
    public ResponseEntity<?>removeBook(@PathVariable Integer libraryId,HttpServletRequest httpReq){
        Integer memberId =(Integer) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        libraryService.deleteBook(libraryId, memberId);
        return ResponseEntity.ok().build();
    }
}
