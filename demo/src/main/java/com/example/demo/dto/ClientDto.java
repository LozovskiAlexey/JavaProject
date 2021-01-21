package com.example.demo.dto;

import com.example.demo.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

// Класс, который служит для передачи данных между слоями
@Data
@Builder
public class ClientDto {

    private Integer id;
    private String name;
    private List<Order> orders;
}
