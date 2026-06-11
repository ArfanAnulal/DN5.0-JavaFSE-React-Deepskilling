package com.pattern.proxy;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {
    @Test
    public void testLazyLoadingAndCaching() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Image image = new ProxyImage("test_photo.jpg");
        
        // At this point, image should not be loaded
        String outputBefore = outContent.toString();
        assertFalse(outputBefore.contains("Loading"));
        assertFalse(outputBefore.contains("Displaying"));

        // First display call
        image.display();
        String outputFirst = outContent.toString();
        assertTrue(outputFirst.contains("Loading test_photo.jpg from remote server..."));
        assertTrue(outputFirst.contains("Displaying test_photo.jpg"));

        // Clear log capture and display again (should be cached)
        outContent.reset();
        image.display();
        String outputSecond = outContent.toString();
        assertFalse(outputSecond.contains("Loading"));
        assertTrue(outputSecond.contains("Displaying test_photo.jpg"));

        System.setOut(System.out);
    }
}
