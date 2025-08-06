package com.example.demo.service;

import com.example.demo.entity.GroceryItem;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.GroceryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryItemServiceTest {

    private GroceryItemRepository repo;
    private GroceryItemService service;

    @BeforeEach
    void setUp() {
        repo = mock(GroceryItemRepository.class);
        service = new GroceryItemService(repo);
    }

    @Test
    void create_shouldSaveAndReturn() {
        GroceryItem in = new GroceryItem(null, "Apple", 10, 5.0);
        GroceryItem saved = new GroceryItem(1L, "Apple", 10, 5.0);
        when(repo.save(any(GroceryItem.class))).thenReturn(saved);
        GroceryItem result = service.create(in);
        assertEquals(1L, result.getId());
        verify(repo, times(1)).save(any(GroceryItem.class));
    }

    @Test
    void getAll_shouldReturnList() {
        when(repo.findAll()).thenReturn(List.of(new GroceryItem(1L,"A",1,1.0)));
        List<GroceryItem> list = service.getAll();
        assertFalse(list.isEmpty());
        verify(repo).findAll();
    }

    @Test
    void getById_whenExists() {
        when(repo.findById(1L)).thenReturn(Optional.of(new GroceryItem(1L,"A",1,1.0)));
        GroceryItem g = service.getById(1L);
        assertEquals(1L, g.getId());
    }

    @Test
    void getById_whenMissing_shouldThrow() {
        when(repo.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.getById(2L));
    }

    @Test
    void update_shouldModifyExisting() {
        GroceryItem existing = new GroceryItem(1L,"A",1,1.0);
        GroceryItem updated = new GroceryItem(null,"B",2,2.0);
        when(repo.findById(1L)).thenReturn(Optional.of(existing));
        when(repo.save(any())).thenAnswer(i -> i.getArgument(0));
        GroceryItem result = service.update(1L, updated);
        assertEquals("B", result.getName());
        assertEquals(2, result.getQuantity());
        assertEquals(2.0, result.getPrice());
    }

    @Test
    void delete_shouldRemove() {
        GroceryItem existing = new GroceryItem(1L,"A",1,1.0);
        when(repo.findById(1L)).thenReturn(Optional.of(existing));
        doNothing().when(repo).delete(existing);
        service.delete(1L);
        verify(repo).delete(existing);
    }
}
