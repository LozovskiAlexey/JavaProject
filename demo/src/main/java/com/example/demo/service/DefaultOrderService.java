package com.example.demo.service;

import com.example.demo.converter.OrderConverter;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Order;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService{

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;
    private final OrderConverter orderConverter;

    @Override
    public List<OrderDto> findAllByClient_Id(Integer id) {
        return orderRepository.findAllByClient_Id(id).stream()
                .map(orderConverter::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(value -> OrderDto.builder()
                .cost(value.getCost())
                .id(value.getId())
                .books(value.getBooks())
                .client(value.getClient())
                .build()).orElse(null);
    }

    @Override
    public void addBookToOrder(Integer orderId, Integer bookId) {
        Optional <Order> optionalOrder = orderRepository.findById(orderId);
        Optional <Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent() && optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.getBooks().add(optionalBook.get());
            order.setCost(order.getCost() + optionalBook.get().getPrice());
            orderRepository.save(order);
        }
    }

    @Override
    public void addOrder(Integer clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isPresent()){
            Order order = new Order();
            order.setCost(0);
            order.setBooks(Collections.emptySet());
            order.setClient(client.get());
            orderRepository.save(order);
        }
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
