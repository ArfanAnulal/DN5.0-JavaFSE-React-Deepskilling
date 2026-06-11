package com.algorithms.sorting;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sorting Customer Orders Output (Exercise 3) ===");
        Order[] orders1 = {
            new Order("O101", "Alice", 250.0),
            new Order("O102", "Bob", 99.99),
            new Order("O103", "Charlie", 450.0),
            new Order("O104", "David", 120.0)
        };
        
        System.out.println("Initial Orders (Unsorted):");
        for (Order o : orders1) {
            System.out.println("- " + o.getOrderId() + ": " + o.getCustomerName() + " ($" + o.getTotalPrice() + ")");
        }
        
        System.out.println("\n1. Running Bubble Sort (Ascending by Price)...");
        SortingAlgorithms.bubbleSort(orders1);
        System.out.println("Sorted Orders (Bubble Sort):");
        for (Order o : orders1) {
            System.out.println("- " + o.getOrderId() + ": " + o.getCustomerName() + " ($" + o.getTotalPrice() + ")");
        }
        
        Order[] orders2 = {
            new Order("O101", "Alice", 250.0),
            new Order("O102", "Bob", 99.99),
            new Order("O103", "Charlie", 450.0),
            new Order("O104", "David", 120.0)
        };
        
        System.out.println("\n2. Running Quick Sort (Ascending by Price)...");
        SortingAlgorithms.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("Sorted Orders (Quick Sort):");
        for (Order o : orders2) {
            System.out.println("- " + o.getOrderId() + ": " + o.getCustomerName() + " ($" + o.getTotalPrice() + ")");
        }
    }
}
