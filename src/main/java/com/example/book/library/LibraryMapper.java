package com.example.book.library;

import com.example.book.library.model.LibraryItemRes;
import com.example.book.library.model.LibraryReq;
import com.example.book.library.model.LibraryRes;
import com.example.book.library.model.userInfo.LastReadBookRes;
import com.example.book.library.model.userInfo.MonthBookList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper {
    void bookSave(LibraryReq req);

    void bookUpdate(LibraryReq req);

    List<LibraryRes> myBookList(Integer memberId);

    List<LibraryRes> myBookListType(Integer memberId, String status);

    LibraryItemRes myBookItem (Long libraryId);

    LastReadBookRes lastReadBook(Integer memberId);

    List<LastReadBookRes> monthFinishBook(MonthBookList req);

    void lastBookUpdate(Integer libraryId);

    void bookStatus (Long libraryId, String status);
    void deleteBook(Integer libraryId, Integer memberId);
}
