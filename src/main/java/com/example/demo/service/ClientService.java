package com.example.demo.service;
import com.example.demo.dto.ClientDto;

import java.util.List;


public interface ClientService {
    ClientDto findByName(String name);
    List<ClientDto> findAll();
    ClientDto addClient(String name);
    void deleteClient(Integer Id);
}
