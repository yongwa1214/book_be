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
    public ResponseEntity<?> saveBook(@RequestBody MemoReq req){
        memoService.save(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/memo/list")
    public ResponseEntity<?> myMemoList(Integer id){
        return ResponseEntity.ok(memoService.myMemoList(id));
    }

    @GetMapping("/memo/detail")
    public ResponseEntity<?> memoDetail(Integer id){ // memoId

        return ResponseEntity.ok(memoService.memoDetail(id));
    }

    @PutMapping("/re/memo")
    public ResponseEntity<?> updateMemo(@RequestBody MemoReq req){
        memoService.updateMemo(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("de/memo")
    public ResponseEntity<?> deleteMemo(Integer id){
        memoService.deleteMemo(id);
        return ResponseEntity.ok().build();
    }

}
