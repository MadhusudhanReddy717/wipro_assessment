package com.example.q12springrestcontroller.controller;

import com.example.q12springrestcontroller.model.Book;
import com.example.q12springrestcontroller.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public String createBook(@RequestBody Book book) {
        repository.save(book);
        return "Book added successfully.";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setBookid(id);
        repository.update(book);
        return "Book updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.delete(id);
        return "Book deleted successfully.";
    }
}
