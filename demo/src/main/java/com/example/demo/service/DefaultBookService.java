package com.example.demo.service;
import com.example.demo.converter.BookConverter;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// TODO подумать как перенести все методы на Optional

@Service
@AllArgsConstructor
public class DefaultBookService implements BookService{
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    @Override
    public BookDto findByName(String Name) {
        Optional<Book> book = bookRepository.findByName(Name);
        return book.map(bookConverter::toBookDto).orElse(null);
    }

    @Override
    public BookDto addBook(String name, Integer price) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setOrders(Collections.emptyList());
        return bookConverter.toBookDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookConverter::toBookDto)
                .collect(Collectors.toList());
    }
}
