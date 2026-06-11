package com.algorithms.inventory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Inventory Management System Output (Exercise 1) ===");
        Inventory inventory = new Inventory();
        Product p1 = new Product("P101", "Laptop", 10, 999.99);
        Product p2 = new Product("P102", "Smartphone", 25, 499.99);
        
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        System.out.println("Added products to inventory:");
        System.out.println("P101: " + inventory.getProduct("P101").getProductName() + ", Qty: " + inventory.getProduct("P101").getQuantity() + ", Price: $" + inventory.getProduct("P101").getPrice());
        System.out.println("P102: " + inventory.getProduct("P102").getProductName() + ", Qty: " + inventory.getProduct("P102").getQuantity() + ", Price: $" + inventory.getProduct("P102").getPrice());
        
        System.out.println("\nUpdating Smartphone (P102) quantity to 30 and price to $479.99...");
        Product p2_updated = new Product("P102", "Smartphone", 30, 479.99);
        inventory.updateProduct("P102", p2_updated);
        System.out.println("P102 (Updated): Qty: " + inventory.getProduct("P102").getQuantity() + ", Price: $" + inventory.getProduct("P102").getPrice());
        
        System.out.println("\nDeleting Laptop (P101)...");
        inventory.deleteProduct("P101");
        System.out.println("Product P101 in inventory: " + (inventory.getProduct("P101") != null));
    }
}
