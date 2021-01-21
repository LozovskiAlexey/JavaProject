package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BookDto;
import com.example.demo.service.DefaultBookService;

import javax.websocket.server.PathParam;
import javax.xml.bind.ValidationException;
import java.util.List;


// вот что-то типа этого будет работаь в браузере
// localhost:9080/books/findByName&name=test
// TODO exception-hander

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final DefaultBookService bookService;

    @PostMapping
    public BookDto addBook(@RequestParam  String name, @RequestParam Integer price) { return bookService.addBook(name, price); }

    @GetMapping("/{name}")
    public BookDto findByName(@PathVariable String name) { return bookService.findByName(name); }

    @GetMapping
    public List<BookDto> findAll(){
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
