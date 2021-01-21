package com.example.demo.converter;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public Book toBook(BookDto bookDto){
        Book book = new Book();

        book.setId(bookDto.getId());
        book.setPrice(bookDto.getPrice());
        book.setName(bookDto.getName());
        book.setOrders(bookDto.getOrders());

        return book;
    }

    public BookDto toBookDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .orders(book.getOrders())
                .build();
    }
}
