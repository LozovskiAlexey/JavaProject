package com.example.demo.dto;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class OrderDto {

    private Integer id;
    private Client client;
    private Integer cost;
    private Set<Book> books;
}
