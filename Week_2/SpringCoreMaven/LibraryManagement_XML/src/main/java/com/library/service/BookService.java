package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Constructor injection support (Exercise 7)
    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter injection support (Exercise 2, 5, 7)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("[BookService]: Business check for adding book '" + title + "'");
        bookRepository.save(title);
    }

    public List<String> listBooks() {
        System.out.println("[BookService]: Retrieving complete library list");
        return bookRepository.findAll();
    }
}
