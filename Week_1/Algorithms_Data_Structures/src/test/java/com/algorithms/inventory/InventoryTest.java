package com.algorithms.inventory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    @Test
    public void testInventoryOperations() {
        Inventory inv = new Inventory();
        Product p1 = new Product("P101", "Laptop", 10, 999.99);
        Product p2 = new Product("P102", "Phone", 20, 499.99);

        // Add
        inv.addProduct(p1);
        inv.addProduct(p2);
        assertEquals(p1, inv.getProduct("P101"));

        // Update
        Product p1Updated = new Product("P101", "Gaming Laptop", 8, 1199.99);
        inv.updateProduct("P101", p1Updated);
        assertEquals("Gaming Laptop", inv.getProduct("P101").getProductName());
        assertEquals(8, inv.getProduct("P101").getQuantity());

        // Delete
        inv.deleteProduct("P102");
        assertNull(inv.getProduct("P102"));
    }
}
