package com.challengue.clients.service;

import com.challengue.clients.models.Client;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    Client save(Client client);
    Optional<Client> findById(UUID id);
    List<Client> findAll();
    void deleteById(UUID id);
}
