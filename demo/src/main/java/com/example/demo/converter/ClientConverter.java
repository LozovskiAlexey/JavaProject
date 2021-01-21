package com.example.demo.converter;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientConverter implements BaseConverter<Client, ClientDto>{
    public Client toClient(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setOrders(clientDto.getOrders());
        return client;
    }

    public ClientDto toClientDto(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .orders(client.getOrders())
                .build();
    }

    @Override
    public Optional<ClientDto> toDto(Optional<Client> obj){
        return obj.map(client -> ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .orders(client.getOrders())
                .build());
    }

    @Override
    public Optional<Client> fromDto(Optional<ClientDto> obj) {

        if (obj.isPresent()){
            Client client = new Client();
            client.setName(obj.get().getName());
            client.setId(obj.get().getId());
            client.setOrders(obj.get().getOrders());
            return Optional.of(client);
        }else{
            return Optional.empty();
        }
    }
}
