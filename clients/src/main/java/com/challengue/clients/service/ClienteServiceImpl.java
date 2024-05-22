package com.challengue.clients.service;

import com.challengue.clients.models.Client;
import com.challengue.clients.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }
}
