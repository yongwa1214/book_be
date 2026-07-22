package com.example.book.library;

import com.example.book.library.model.LibraryReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;

    public void bookSave(Integer memberId, LibraryReq req){
        LibraryReq dto = LibraryReq.builder()
                .memberId(memberId)
                .bookName(req.getBookName())
                .status(req.getStatus())
                .build();
        libraryMapper.bookSave(dto);
    }
}
