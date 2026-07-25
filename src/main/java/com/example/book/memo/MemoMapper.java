package com.example.book.memo;


import com.example.book.library.model.LibraryReq;
import com.example.book.library.model.LibraryRes;
import com.example.book.memo.model.MemoDetailRes;
import com.example.book.memo.model.MemoListRes;
import com.example.book.memo.model.MemoReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    void save (MemoReq req);

    List<MemoListRes> myMemoList(Integer libraryId, String type);

    MemoDetailRes memoDetail(Integer memoId);

    void updateMemo(MemoReq req);

    void deleteMemo(Integer memoId);

}
