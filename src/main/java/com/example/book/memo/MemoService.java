package com.example.book.memo;


import com.example.book.library.model.LibraryReq;
import com.example.book.memo.model.MemoDetailRes;
import com.example.book.memo.model.MemoListRes;
import com.example.book.memo.model.MemoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoMapper memoMapper;

    public void save(MemoReq req){
        memoMapper.save(req);
    }

    public List<MemoListRes> myMemoList(Integer libraryId){
        return memoMapper.myMemoList(libraryId);
    }

    public MemoDetailRes memoDetail (Integer memoId){
        return memoMapper.memoDetail(memoId);
    }

    public void updateMemo(MemoReq req){
        memoMapper.updateMemo(req);
    }

    public void deleteMemo(Integer memoId){
        memoMapper.deleteMemo(memoId);
    }
}
