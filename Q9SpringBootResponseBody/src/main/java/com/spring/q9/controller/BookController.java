package com.spring.q9.controller;

import com.spring.q9.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/showBooks")
    public List<Book> showBooks() {
        return Arrays.asList(
            new Book(101, "Spring in Action", "Craig Walls"),
            new Book(102, "Effective Java", "Joshua Bloch"),
            new Book(103, "Clean Code", "Robert C. Martin")
        );
    }
}
