package br.com.takahashi.unittests.mapper.mocks;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.takahashi.data.vo.v1.BookVO;
import br.com.takahashi.model.Book;

public class MockBook {
    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookVO mockVO() {
        return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 12; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        if(number == 0) number = 1;
        book.setAuthor("Author"+ number);
        book.setLaunchDate(LocalDateTime.of(number, number, number, number, number));
        book.setPrice(BigDecimal.valueOf(number.longValue()));
        book.setTitle("title" + number);
        book.setId(number);
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        if(number == 0) number = 1;
        book.setAuthor("Author"+ number);
        book.setLaunchDate(LocalDateTime.of(number, number, number, number, number));
        book.setPrice(BigDecimal.valueOf(number.longValue()));
        book.setTitle("title" + number);
        book.setKey(number);
        return book;
    }
}
