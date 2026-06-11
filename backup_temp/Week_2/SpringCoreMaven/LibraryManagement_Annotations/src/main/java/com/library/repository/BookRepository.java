package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Clean Code (Annotations)");
        books.add("Design Patterns (Annotations)");
    }

    public List<String> findAll() {
        System.out.println("[BookRepository]: Querying scanned repository...");
        return new ArrayList<>(books);
    }

    public void save(String title) {
        System.out.println("[BookRepository]: Scanned repository saved '" + title + "'");
        books.add(title);
    }
}
