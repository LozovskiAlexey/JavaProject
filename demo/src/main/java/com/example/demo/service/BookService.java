package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;


public interface BookService {
    BookDto findByName(String Name);
    BookDto addBook(String name, Integer id);
    void deleteBook(Integer id);
    List<BookDto> findAll();
}
