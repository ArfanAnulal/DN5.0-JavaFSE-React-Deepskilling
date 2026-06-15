package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Spring XML Configuration & AOP Execution Output ===");
        
        // Load the XML Application Context (Exercise 1, 5)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve injected BookService bean (Exercise 2)
        BookService service = (BookService) context.getBean("bookService");
        
        // Execute operations to trigger AOP advices (Exercise 3, 8)
        System.out.println("\n--- Executing service.addBook() ---");
        service.addBook("Effective Java");
        
        System.out.println("\n--- Executing service.listBooks() ---");
        java.util.List<String> books = service.listBooks();
        System.out.println("Result Library books: " + books);
    }
}
