package com.example.demo.service;
import com.example.demo.repository.ClientRepository;
import com.example.demo.converter.ClientConverter;
import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DefaultClientService implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    @Override
    public ClientDto findByName(String name) {
        Client client = clientRepository.findByName(name);
        if (client != null){
            return clientConverter.toClientDto(client);
        }else{
            return null;
        }
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().
                map(clientConverter::toClientDto).
                collect(Collectors.toList());
    }

    @Override
    public ClientDto addClient(String name) {
        Client client = new Client();
        client.setName(name);
        client.setOrders(Collections.emptyList());
        return clientConverter.toClientDto(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
