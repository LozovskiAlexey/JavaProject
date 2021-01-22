package com.example.demo.repository;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO подумать какие методы можно добавить в заказы

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByClient_Id(Integer id);
}
