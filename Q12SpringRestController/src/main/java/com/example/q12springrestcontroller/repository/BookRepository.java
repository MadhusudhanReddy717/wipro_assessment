package com.example.q12springrestcontroller.repository;

import com.example.q12springrestcontroller.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setBookid(rs.getInt("bookid"));
        book.setBookname(rs.getString("bookname"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getInt("price"));
        return book;
    };

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", rowMapper);
    }

    public Book findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE bookid = ?", rowMapper, id);
    }

    public int save(Book book) {
        return jdbcTemplate.update(
            "INSERT INTO books (bookid, bookname, author, price) VALUES (?, ?, ?, ?)",
            book.getBookid(), book.getBookname(), book.getAuthor(), book.getPrice()
        );
    }

    public int update(Book book) {
        return jdbcTemplate.update(
            "UPDATE books SET bookname = ?, author = ?, price = ? WHERE bookid = ?",
            book.getBookname(), book.getAuthor(), book.getPrice(), book.getBookid()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM books WHERE bookid = ?", id);
    }
}
