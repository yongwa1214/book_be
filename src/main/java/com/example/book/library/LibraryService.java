package com.example.book.library;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;
}
