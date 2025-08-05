package com.spring.q9.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private int bookId;
    private String name;
    private String writer;

    public Book() {}

    public Book(int bookId, String name, String writer) {
        this.bookId = bookId;
        this.name = name;
        this.writer = writer;
    }

    // Getters and setters
}
