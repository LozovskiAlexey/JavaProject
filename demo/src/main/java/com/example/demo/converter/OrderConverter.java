package com.example.demo.converter;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public OrderDto toOrderDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .books(order.getBooks())
                .client(order.getClient())
                .cost(order.getCost())
                .build();
    }

    public Order toOrder(OrderDto orderDto){
        Order order = new Order();
        order.setClient(orderDto.getClient());
        order.setCost(orderDto.getCost());
        order.setBooks(orderDto.getBooks());
        order.setId(orderDto.getId());
        return order;
    }
}
