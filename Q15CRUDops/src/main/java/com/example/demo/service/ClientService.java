package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) { this.repo = repo; }

    public List<Client> getAllClients() { return repo.findAll(); }

    public Client getClient(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found: " + id));
    }

    public Client saveClient(Client client) { return repo.save(client); }

    public Client updateClient(Long id, Client updated) {
        Client c = getClient(id);
        c.setName(updated.getName());
        c.setEmail(updated.getEmail());
        c.setPhone(updated.getPhone());
        c.setAddress(updated.getAddress());
        return repo.save(c);
    }

    public void deleteClient(Long id) {
        Client c = getClient(id);
        repo.delete(c);
    }
}
