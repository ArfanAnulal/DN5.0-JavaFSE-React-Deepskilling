package com.algorithms.library;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System Output (Exercise 6) ===");
        Book[] books = {
            new Book("B001", "Clean Code", "Robert C. Martin"),
            new Book("B002", "Design Patterns", "Erich Gamma"),
            new Book("B003", "Effective Java", "Joshua Bloch"),
            new Book("B004", "Introduction to Algorithms", "Thomas H. Cormen")
        };
        
        System.out.println("Books in Library:");
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
        
        System.out.println("\n1. Executing Linear Search for 'Effective Java':");
        Book res1 = LibraryManagement.linearSearchByTitle(books, "Effective Java");
        System.out.println(res1 != null ? "Found Book: " + res1.getTitle() + " (Author: " + res1.getAuthor() + ")" : "Not Found");
        
        System.out.println("\n2. Executing Binary Search for 'Effective Java':");
        Book res2 = LibraryManagement.binarySearchByTitle(books, "Effective Java");
        System.out.println(res2 != null ? "Found Book: " + res2.getTitle() + " (Author: " + res2.getAuthor() + ")" : "Not Found");
        
        System.out.println("\n3. Executing Linear Search for 'Refactoring':");
        Book res3 = LibraryManagement.linearSearchByTitle(books, "Refactoring");
        System.out.println(res3 != null ? "Found Book: " + res3.getTitle() : "Not Found");
        
        System.out.println("\n4. Executing Binary Search for 'Refactoring':");
        Book res4 = LibraryManagement.binarySearchByTitle(books, "Refactoring");
        System.out.println(res4 != null ? "Found Book: " + res4.getTitle() : "Not Found");
    }
}
