package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Spring Annotation Scanning Execution Output ===");
        
        // Load the component scanning XML Application Context (Exercise 6)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve scanned BookService bean
        BookService service = context.getBean(BookService.class);
        
        System.out.println("\n--- Adding book via Autowired Scanned Service ---");
        service.addBook("Spring in Action");
        
        System.out.println("\n--- Querying list via Autowired Scanned Service ---");
        java.util.List<String> books = service.listBooks();
        System.out.println("Result Scanned Library books: " + books);
    }
}
