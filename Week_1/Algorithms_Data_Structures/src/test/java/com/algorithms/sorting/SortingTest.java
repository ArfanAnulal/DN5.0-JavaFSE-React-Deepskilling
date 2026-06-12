package com.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {
    @Test
    public void testBubbleSort() {
        Order[] orders = {
            new Order("O001", "Alice", 250.0),
            new Order("O002", "Bob", 120.0),
            new Order("O003", "Charlie", 450.0),
            new Order("O004", "Diana", 80.0)
        };
        SortingAlgorithms.bubbleSort(orders);
        assertEquals(80.0, orders[0].getTotalPrice());
        assertEquals(120.0, orders[1].getTotalPrice());
        assertEquals(250.0, orders[2].getTotalPrice());
        assertEquals(450.0, orders[3].getTotalPrice());
    }

    @Test
    public void testQuickSort() {
        Order[] orders = {
            new Order("O001", "Alice", 250.0),
            new Order("O002", "Bob", 120.0),
            new Order("O003", "Charlie", 450.0),
            new Order("O004", "Diana", 80.0)
        };
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        assertEquals(80.0, orders[0].getTotalPrice());
        assertEquals(120.0, orders[1].getTotalPrice());
        assertEquals(250.0, orders[2].getTotalPrice());
        assertEquals(450.0, orders[3].getTotalPrice());
    }
}
