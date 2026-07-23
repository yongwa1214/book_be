package com.example.book.library;

import com.example.book.library.model.BookSearchList;
import com.example.book.library.model.BookSearchReq;
import com.example.book.library.model.GoogleBooksRes;
import com.example.book.library.model.LibraryReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;
    private final WebClient webClient;

    public void bookSave(Integer memberId, LibraryReq req){
        LibraryReq dto = LibraryReq.builder()
                .memberId(memberId)
                .bookName(req.getBookName())
                .status(req.getStatus())
                .build();
        libraryMapper.bookSave(dto);
    }

    public BookSearchList bookSearch (BookSearchReq searchReq){
            //q 生成
        String q = createQuery(searchReq);

        int startIndex = (searchReq.getPage() -1)*20;

        GoogleBooksRes res = webClient.get() //get方式で要求します。
                .uri(uriBuilder -> uriBuilder //今からurlを作ります
                        .path("/volumes") //path　生成
                        .queryParam("q", q) //queryParam生成
                                .queryParam("startIndex", startIndex)
                                .queryParam("maxResults", 20)
                                .build())
                .retrieve() //실제로 Google 서버에 요청을 보내고 응답을 받습니다.
                .bodyToMono(GoogleBooksRes.class) //JSON을 객체로 자동 변환
                .block();


        return null;
    }

    private String createQuery(BookSearchReq req) {

        if ("TITLE".equals(req.getSearchType())) {
            return "intitle:" + req.getKeyword();
        }

        return "inauthor:" + req.getKeyword();
    }
}
