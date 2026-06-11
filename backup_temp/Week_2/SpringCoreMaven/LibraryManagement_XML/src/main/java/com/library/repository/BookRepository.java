package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        // Seed default books
        books.add("Clean Code");
        books.add("Design Patterns");
    }

    public List<String> findAll() {
        System.out.println("[BookRepository]: Querying all books from database...");
        return new ArrayList<>(books);
    }

    public void save(String title) {
        System.out.println("[BookRepository]: Saving book '" + title + "' to database...");
        books.add(title);
    }
}
