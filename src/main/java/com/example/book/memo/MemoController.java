package com.example.book.memo;


import com.example.book.memo.model.MemoReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/bobo")
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/save/memo")
    public ResponseEntity<?> saveBookMemo(@RequestBody MemoReq req){
        memoService.save(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{libraryId}/memo/list")
    public ResponseEntity<?> myMemoList(@PathVariable Integer libraryId, @RequestParam String type){
        return ResponseEntity.ok(memoService.myMemoList(libraryId, type));
    }

    @GetMapping("/memo/{memoId}")
    public ResponseEntity<?> memoDetail(@PathVariable Integer memoId){ // memoId

        return ResponseEntity.ok(memoService.memoDetail(memoId));
    }

    @PutMapping("/re/memo")
    public ResponseEntity<?> updateMemo(@RequestBody MemoReq req){
        memoService.updateMemo(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("de/memo/{memoId}")
    public ResponseEntity<?> deleteMemo(@PathVariable Integer memoId){
        memoService.deleteMemo(memoId);
        return ResponseEntity.ok().build();
    }

}
