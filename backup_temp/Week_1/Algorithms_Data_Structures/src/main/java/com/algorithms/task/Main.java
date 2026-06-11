package com.algorithms.task;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Task Management System Output (Exercise 5) ===");
        TaskManagement tm = new TaskManagement();
        
        tm.addTask(new Task("T201", "Review Code", "Pending"));
        tm.addTask(new Task("T202", "Write Tests", "In Progress"));
        tm.addTask(new Task("T203", "Deploy App", "Pending"));
        
        System.out.println("All Tasks:");
        tm.traverseTasks();
        
        System.out.println("\nSearching for Task T202:");
        Task found = tm.searchTask("T202");
        System.out.println(found != null ? "Found: " + found.getTaskName() + " (" + found.getStatus() + ")" : "Not Found");
        
        System.out.println("\nDeleting Task T201...");
        tm.deleteTask("T201");
        
        System.out.println("\nRemaining Tasks:");
        tm.traverseTasks();
    }
}
