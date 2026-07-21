package com.ecommerce.search;

public class SearchEngine {
    
    // basic linear search algorithm
    public static Item findItemLinear(Item[] items, String targetId) {
        for (Item item : items) {
            if (item.getId().equals(targetId)) {
                return item;
            }
        }
        return null;
    }

    // optimized binary search for sorted item arrays
    public static Item findItemBinary(Item[] sortedItems, String targetId) {
        int left = 0;
        int right = sortedItems.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedItems[mid].getId().compareTo(targetId);

            if (comparison == 0) {
                return sortedItems[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
