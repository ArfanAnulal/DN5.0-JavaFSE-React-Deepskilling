package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<String> bookCatalog = new ArrayList<>();

    public BookRepository() {
        // Pre-populating repository with initial inventory
        bookCatalog.add("Clean Architecture");
        bookCatalog.add("Refactoring");
        bookCatalog.add("Head First Design Patterns");
    }

    public List<String> findAllBooks() {
        System.out.println("[BookRepository] Fetching all records from database...");
        return new ArrayList<>(bookCatalog);
    }

    public void saveBook(String title) {
        System.out.println("[BookRepository] Persisting new book title: '" + title + "'");
        bookCatalog.add(title);
    }
}
