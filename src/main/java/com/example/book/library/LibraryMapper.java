package com.example.book.library;

import com.example.book.library.model.LibraryItemRes;
import com.example.book.library.model.LibraryReq;
import com.example.book.library.model.LibraryRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper {
    void bookSave(LibraryReq req);

    void bookUpdate(LibraryReq req);

    List<LibraryRes> myBookList(Integer memberId);

    LibraryItemRes myBookItem (Long libraryId);

    void bookStatus (Long libraryId, String status);
    void deleteBook(Integer libraryId, Integer memberId);
}
