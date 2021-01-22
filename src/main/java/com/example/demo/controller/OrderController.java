package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import com.example.demo.service.DefaultOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final DefaultOrderService defaultOrderService;

    @PostMapping("/client/{id}")
    public void addOrder(@PathVariable Integer id) { defaultOrderService.addOrder(id); }

    @GetMapping("/order/{id}")
    public OrderDto findById(@PathVariable Integer id) { return defaultOrderService.findById(id); }

    @GetMapping("/{id}")
    public List<OrderDto> findAllByClient_id(@PathVariable Integer id) { return defaultOrderService.findAllByClient_Id(id); }

    @PostMapping("/{id}/book/{bookId}")
    void addBookToOrder(@PathVariable Integer id, @PathVariable Integer bookId) {
        defaultOrderService.addBookToOrder(id, bookId);
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id){ defaultOrderService.deleteOrder(id); }
}
