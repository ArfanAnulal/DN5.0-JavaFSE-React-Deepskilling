package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Default constructor for Spring XML bean instantiation
    public BookService() {
    }

    // Constructor injection option
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for Spring Dependency Injection (Exercise 2)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("[BookService] Processing request to add book: '" + title + "'");
        bookRepository.saveBook(title);
    }

    public List<String> listBooks() {
        System.out.println("[BookService] Retrieving full book catalog from repository...");
        return bookRepository.findAllBooks();
    }
}
