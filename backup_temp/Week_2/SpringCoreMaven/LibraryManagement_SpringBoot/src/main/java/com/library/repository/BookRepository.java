package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Clean Code (Spring Boot)");
        books.add("Design Patterns (Spring Boot)");
    }

    public List<String> findAll() {
        System.out.println("[BookRepository]: Querying Spring Boot repository...");
        return new ArrayList<>(books);
    }

    public void save(String title) {
        System.out.println("[BookRepository]: Spring Boot repository saved '" + title + "'");
        books.add(title);
    }
}
