package com.algorithms.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskOperations() {
        TaskManagement tm = new TaskManagement();
        Task t1 = new Task("T01", "Design DB Schema", "Done");
        Task t2 = new Task("T02", "Implement API endpoints", "In Progress");
        Task t3 = new Task("T03", "Write unit tests", "Pending");

        tm.addTask(t1);
        tm.addTask(t2);
        tm.addTask(t3);

        assertEquals("Implement API endpoints", tm.searchTask("T02").getTaskName());

        tm.deleteTask("T02");
        assertNull(tm.searchTask("T02"));
        assertNotNull(tm.searchTask("T03"));
    }
}
