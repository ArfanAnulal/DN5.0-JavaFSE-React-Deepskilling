package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("[BookService]: Boot service saving book '" + title + "'");
        bookRepository.save(title);
    }

    public List<String> listBooks() {
        System.out.println("[BookService]: Boot service listing books");
        return bookRepository.findAll();
    }
}
