package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System (Spring IoC & DI Demo) ===");

        // Load Application Context from XML Configuration (Exercise 1)
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {

            // Retrieve the wired BookService bean (Exercise 2)
            BookService bookService = context.getBean("bookService", BookService.class);

            System.out.println("\n--- Testing Book Addition ---");
            bookService.addBook("Spring Boot in Action");

            System.out.println("\n--- Fetching Library Catalog ---");
            List<String> books = bookService.listBooks();
            System.out.println("Updated Library Catalog: " + books);
        }
    }
}
