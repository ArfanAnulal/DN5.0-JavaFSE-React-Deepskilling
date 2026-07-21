package com.ecommerce.search;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SearchEngineTest {
    @Test
    public void testSearchCapabilities() {
        Item[] inventory = {
            new Item("I103", "Tablet", "Electronics"),
            new Item("I101", "Laptop", "Electronics"),
            new Item("I105", "Desk", "Furniture"),
            new Item("I102", "Phone", "Electronics"),
            new Item("I104", "Chair", "Furniture")
        };

        // Linear Search test
        Item resultLinear = SearchEngine.findItemLinear(inventory, "I105");
        assertNotNull(resultLinear);
        assertEquals("Desk", resultLinear.getName());

        // Binary Search test (Requires sorted array)
        Arrays.sort(inventory);
        Item resultBinary = SearchEngine.findItemBinary(inventory, "I105");
        assertNotNull(resultBinary);
        assertEquals("Desk", resultBinary.getName());

        // Test non-existing item
        assertNull(SearchEngine.findItemBinary(inventory, "I999"));
    }
}
