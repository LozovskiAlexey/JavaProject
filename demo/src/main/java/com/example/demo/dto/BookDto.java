package com.example.demo.dto;

import com.example.demo.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

// Класс, который служит для передачи данных между слоями
@Data
@Builder
public class BookDto {

    private Integer id;
    private String name;
    private Integer price;
    private List<Order> orders;
}
