package com.ecommerce.search;

public class StoreFront {
    public static void main(String[] args) {
        System.out.println("--- E-Commerce Search Test ---");
        
        // Sample data
        Item[] inventory = {
            new Item("I001", "Laptop", "Electronics"),
            new Item("I002", "Mouse", "Accessories"),
            new Item("I003", "Notebook", "Stationery"),
            new Item("I004", "Pen", "Stationery")
        };
        
        System.out.println("Current Inventory:");
        for (Item i : inventory) {
            System.out.println(" -> [" + i.getId() + "] " + i.getName() + " - " + i.getCategory());
        }
        
        System.out.println("\nTesting Linear Search for 'I003'...");
        Item foundLinear = SearchEngine.findItemLinear(inventory, "I003");
        System.out.println("Result: " + (foundLinear != null ? foundLinear.getName() : "Item Not Found"));
        
        System.out.println("\nTesting Binary Search for 'I003'...");
        Item foundBinary = SearchEngine.findItemBinary(inventory, "I003");
        System.out.println("Result: " + (foundBinary != null ? foundBinary.getName() : "Item Not Found"));
        
        System.out.println("\nTesting search for non-existent item 'I999'...");
        Item missing = SearchEngine.findItemBinary(inventory, "I999");
        System.out.println("Result: " + (missing != null ? missing.getName() : "Item Not Found"));
    }
}
