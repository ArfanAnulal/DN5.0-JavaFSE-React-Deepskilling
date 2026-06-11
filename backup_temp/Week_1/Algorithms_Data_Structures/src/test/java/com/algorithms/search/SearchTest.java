package com.algorithms.search;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    @Test
    public void testSearchAlgorithms() {
        Product[] products = {
            new Product("P103", "Tablet", "Electronics"),
            new Product("P101", "Laptop", "Electronics"),
            new Product("P105", "Desk", "Furniture"),
            new Product("P102", "Phone", "Electronics"),
            new Product("P104", "Chair", "Furniture")
        };

        // Linear Search
        Product res1 = SearchAlgorithms.linearSearch(products, "P105");
        assertNotNull(res1);
        assertEquals("Desk", res1.getProductName());

        // Binary Search (Requires sorted array)
        Arrays.sort(products);
        Product res2 = SearchAlgorithms.binarySearch(products, "P105");
        assertNotNull(res2);
        assertEquals("Desk", res2.getProductName());

        // Test non-existing product
        assertNull(SearchAlgorithms.binarySearch(products, "P999"));
    }
}
