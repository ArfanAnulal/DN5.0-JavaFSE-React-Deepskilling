package com.pattern.mvc;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MVCTest {
    @Test
    public void testMvcFlow() {
        Student model = new Student();
        model.setId("S001");
        model.setName("Alice");
        model.setGrade("A+");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.updateView();
        String out1 = outContent.toString();
        assertTrue(out1.contains("Alice"));
        assertTrue(out1.contains("S001"));
        assertTrue(out1.contains("A+"));

        // Update model details via controller
        outContent.reset();
        controller.setStudentName("Bob");
        controller.setStudentGrade("A-");
        controller.updateView();
        
        String out2 = outContent.toString();
        assertTrue(out2.contains("Bob"));
        assertTrue(out2.contains("S001"));
        assertTrue(out2.contains("A-"));

        System.setOut(System.out);
    }
}
