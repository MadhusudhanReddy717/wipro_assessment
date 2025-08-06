package com.example.demo.service;

import com.example.demo.entity.GroceryItem;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public GroceryItem create(GroceryItem item) {
        item.setId(null);
        return repo.save(item);
    }

    public List<GroceryItem> getAll() {
        return repo.findAll();
    }

    public GroceryItem getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("GroceryItem not found: " + id));
    }

    public GroceryItem update(Long id, GroceryItem updated) {
        GroceryItem existing = getById(id);
        existing.setName(updated.getName());
        existing.setQuantity(updated.getQuantity());
        existing.setPrice(updated.getPrice());
        return repo.save(existing);
    }

    public void delete(Long id) {
        GroceryItem existing = getById(id);
        repo.delete(existing);
    }
}
