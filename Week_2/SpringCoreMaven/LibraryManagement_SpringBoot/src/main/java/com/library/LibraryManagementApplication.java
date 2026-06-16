package com.library;

import com.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Spring Boot Bootstrapping Execution Output ===");
        
        // Start Spring Boot context (Exercise 9)
        ApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);
        
        // Retrieve and execute service bean
        BookService service = context.getBean(BookService.class);
        
        System.out.println("\n--- Adding book via Bootstrapped service ---");
        service.addBook("Pro Spring 6");
        
        System.out.println("\n--- Querying list via Bootstrapped service ---");
        java.util.List<String> books = service.listBooks();
        System.out.println("Result Boot Library books: " + books);
    }
}
