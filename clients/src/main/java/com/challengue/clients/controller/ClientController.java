package com.challengue.clients.controller;

import com.challengue.clients.models.Client;
import com.challengue.clients.models.ClientDTO;
import com.challengue.clients.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> createCLient(@Valid @RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Client> clients = clientService.findAll();
        List<ClientDTO> clientDTOList = new ArrayList<>();
        ClientDTO clientDTO = new ClientDTO();
        for (Client client : clients
             ) {
            clientDTO.setId(client.getId());
            clientDTO.setFullName(client.getName() +" "+ client.getLastName() +" "+ client.getMotherLastName());
            clientDTOList.add(clientDTO);
        }
        return ResponseEntity.ok(clientDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") UUID id) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientOptional);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Client client, @PathVariable(value = "id") UUID id) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientOptional.get().setName(client.getName());
        clientOptional.get().setLastName(client.getLastName());
        clientOptional.get().setMotherLastName(client.getMotherLastName());
        clientOptional.get().setStatus(client.isStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientOptional.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        if (clientService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
