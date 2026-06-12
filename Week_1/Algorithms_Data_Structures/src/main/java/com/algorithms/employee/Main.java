package com.algorithms.employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System Output (Exercise 4) ===");
        EmployeeManagement manager = new EmployeeManagement(2);
        
        Employee e1 = new Employee("E001", "John Doe", "Manager", 90000.0);
        Employee e2 = new Employee("E002", "Jane Smith", "Developer", 80000.0);
        Employee e3 = new Employee("E003", "Sam Brown", "Analyst", 60000.0);
        
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3); // triggers array resizing
        
        System.out.println("All Employees:");
        manager.traverseEmployees();
        
        System.out.println("\nSearching for Employee E002:");
        Employee found = manager.searchEmployee("E002");
        System.out.println(found != null ? "Found: " + found.getName() : "Not Found");
        
        System.out.println("\nDeleting Employee E001...");
        manager.deleteEmployee("E001");
        
        System.out.println("\nRemaining Employees:");
        manager.traverseEmployees();
    }
}
