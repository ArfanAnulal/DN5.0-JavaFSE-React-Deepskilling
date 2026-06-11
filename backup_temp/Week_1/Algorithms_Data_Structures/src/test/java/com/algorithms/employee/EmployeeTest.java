package com.algorithms.employee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    public void testEmployeeOperations() {
        EmployeeManagement em = new EmployeeManagement(2);
        Employee e1 = new Employee("E001", "Alice", "Manager", 80000.0);
        Employee e2 = new Employee("E002", "Bob", "Developer", 60000.0);
        Employee e3 = new Employee("E003", "Charlie", "Designer", 55000.0);

        // Add (should trigger auto-resizing since capacity starts at 2)
        em.addEmployee(e1);
        em.addEmployee(e2);
        em.addEmployee(e3);
        assertEquals(3, em.getSize());

        // Search
        Employee found = em.searchEmployee("E002");
        assertNotNull(found);
        assertEquals("Bob", found.getName());

        // Delete
        em.deleteEmployee("E002");
        assertEquals(2, em.getSize());
        assertNull(em.searchEmployee("E002"));
    }
}
