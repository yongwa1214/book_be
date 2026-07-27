package com.example.book.library;

import com.example.book.common.config.GoogleBookProperties;
import com.example.book.common.constant.Constants;
import com.example.book.library.model.*;
import com.example.book.library.model.googleBook.GoogleBooksRes;
import com.example.book.library.model.googleBook.VolumeInfo;
import com.example.book.library.model.userInfo.LastReadBookRes;
import com.example.book.library.model.userInfo.MonthBookList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;
    private final GoogleBookProperties properties;
    private final WebClient webClient;


    public void bookSave(Integer memberId, LibraryReq req){
        req.setMemberId(memberId);
        libraryMapper.bookSave(req);
    }

    public BookSearchList bookSearch (BookSearchReq searchReq){
            //q 生成
        String q = createQuery(searchReq);

        int startIndex = (searchReq.getPage() -1)* Constants.MAX_PAGE;

        GoogleBooksRes res = webClient.get() //get方式で要求します。
                .uri(uriBuilder -> uriBuilder //今からurlを作ります
                        .path("/volumes") //path　生成
                        .queryParam("q", q) //queryParam生成
                                .queryParam("startIndex", startIndex)
                                .queryParam("maxResults", Constants.MAX_PAGE)
                        .queryParam("key", properties.getApiKey())
                                .build())
                .retrieve() //실제로 Google 서버에 요청을 보내고 응답을 받습니다.
                .bodyToMono(GoogleBooksRes.class) //JSON을 객체로 자동 변환
                .block();

        List<BookSearchItem> items = res.getItems().stream()
                .map(item ->{
                    BookSearchItem dto = BookSearchItem.builder()
                            .id(item.getId())
                            .title(item.getVolumeInfo().getTitle())
                            .authors(item.getVolumeInfo().getAuthors())
                            .publisher(item.getVolumeInfo().getPublisher())
                            .publishedDate(item.getVolumeInfo().getPublishedDate())
                            .description(item.getVolumeInfo().getDescription())
                            .pageCount(item.getVolumeInfo().getPageCount())
                            .thumbnail(getThumbnail(item.getVolumeInfo()))
                            .build();

                    return dto;
                        })
                .toList();
        BookSearchList bookList = BookSearchList.builder()
                .results(items)
                .page(searchReq.getPage())
                .size(Constants.MAX_PAGE)
                .totalItems(res.getTotalItems())
                .build();


        return bookList;
    }

    private String createQuery(BookSearchReq req) {

        if ("title".equals(req.getType())) {
            return "intitle:" + req.getKeyword();
        }

        return "inauthor:" + req.getKeyword();
    }

    private String getThumbnail(VolumeInfo volumeInfo) {
        if (volumeInfo.getImageLinks() == null) {
            return null;
        }
        return volumeInfo.getImageLinks().getThumbnail();
    }

    public List<LibraryRes> myBookList (Integer memberId){
        return libraryMapper.myBookList(memberId);
    }

    public List<LibraryRes> myBookListType (Integer memberId, String status){
        return libraryMapper.myBookListType(memberId, status);
    }


    public LastReadBookRes lastReadBook(Integer memoId){
        return libraryMapper.lastReadBook(memoId);
    }


    public LibraryItemRes myBookItem (Long libraryId){
        return libraryMapper.myBookItem(libraryId);
    }

    public List<LastReadBookRes> monthFinishBook(Integer memberId){
        LocalDate startDate = LocalDate.now().withDayOfMonth(1);
        LocalDate endDate = startDate.plusMonths(1);

        MonthBookList req = MonthBookList.builder()
                .memberId(memberId)
                .start(startDate)
                .end(endDate)
                .build();
        return libraryMapper.monthFinishBook(req);
    }

    public void bookStatus (Long libraryId, String status){
        libraryMapper.bookStatus(libraryId,status);
    }
    public void bookUpdate(LibraryReq req){
        libraryMapper.bookUpdate(req);
    }

    public void lastBookUpdate(Integer libraryId){
        libraryMapper.lastBookUpdate(libraryId);
    }
    public void deleteBook(Integer libraryId, Integer memberId){
        libraryMapper.deleteBook(libraryId, memberId);
    }
}
