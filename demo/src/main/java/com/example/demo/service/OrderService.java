package com.example.demo.service;

import com.example.demo.dto.OrderDto;


import java.util.List;

public interface OrderService {
    void addBookToOrder(Integer orderId, Integer bookId);
    void addOrder(Integer id);
    void deleteOrder(Integer id);
    List<OrderDto> findAllByClient_Id(Integer id);
    OrderDto findById(Integer id);
}
