package com.algorithms.search;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Search Algorithms Output (Exercise 2) ===");
        Product[] products = {
            new Product("P101", "Book", "Books"),
            new Product("P102", "Headphones", "Electronics"),
            new Product("P103", "Keyboard", "Electronics"),
            new Product("P104", "Monitor", "Electronics")
        };
        
        System.out.println("Products List:");
        for (Product p : products) {
            System.out.println("- " + p.getProductId() + ": " + p.getProductName() + " (" + p.getCategory() + ")");
        }
        
        System.out.println("\n1. Executing Linear Search for product 'P103':");
        Product res1 = SearchAlgorithms.linearSearch(products, "P103");
        System.out.println("Result: " + (res1 != null ? "Found " + res1.getProductName() : "Not Found"));
        
        System.out.println("\n2. Executing Binary Search for product 'P103':");
        Product res2 = SearchAlgorithms.binarySearch(products, "P103");
        System.out.println("Result: " + (res2 != null ? "Found " + res2.getProductName() : "Not Found"));
        
        System.out.println("\n3. Executing Linear Search for product 'P999':");
        Product res3 = SearchAlgorithms.linearSearch(products, "P999");
        System.out.println("Result: " + (res3 != null ? "Found " + res3.getProductName() : "Not Found"));
        
        System.out.println("\n4. Executing Binary Search for product 'P999':");
        Product res4 = SearchAlgorithms.binarySearch(products, "P999");
        System.out.println("Result: " + (res4 != null ? "Found " + res4.getProductName() : "Not Found"));
    }
}
