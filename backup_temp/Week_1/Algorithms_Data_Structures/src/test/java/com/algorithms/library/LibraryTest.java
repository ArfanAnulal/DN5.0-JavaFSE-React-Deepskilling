package com.algorithms.library;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void testLibrarySearch() {
        Book[] books = {
            new Book("B01", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B02", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B03", "1984", "George Orwell"),
            new Book("B04", "Pride and Prejudice", "Jane Austen")
        };

        // Linear Search
        Book res1 = LibraryManagement.linearSearchByTitle(books, "1984");
        assertNotNull(res1);
        assertEquals("George Orwell", res1.getAuthor());

        // Binary Search
        Arrays.sort(books); // must sort first
        Book res2 = LibraryManagement.binarySearchByTitle(books, "Pride and Prejudice");
        assertNotNull(res2);
        assertEquals("Jane Austen", res2.getAuthor());

        // Search missing
        assertNull(LibraryManagement.binarySearchByTitle(books, "Moby Dick"));
    }
}
