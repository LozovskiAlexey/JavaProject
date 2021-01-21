package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.service.DefaultClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final DefaultClientService defaultClientService;

    @PostMapping("/{name}")
    public ClientDto addClient(@PathVariable String name) { return defaultClientService.addClient(name); }

    @GetMapping("/{name}")
    public ClientDto findByName(@PathVariable String name){
        return defaultClientService.findByName(name);
    }

    @GetMapping
    public List<ClientDto> findAll() { return defaultClientService.findAll(); }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) { defaultClientService.deleteClient(id);}
}
