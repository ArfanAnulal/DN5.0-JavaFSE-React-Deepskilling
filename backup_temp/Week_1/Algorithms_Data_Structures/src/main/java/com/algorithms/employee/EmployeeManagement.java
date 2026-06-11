package com.algorithms.employee;

import java.util.Arrays;

public class EmployeeManagement {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagement(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size >= capacity) {
            // Resize array
            capacity *= 2;
            employees = Arrays.copyOf(employees, capacity);
        }
        employees[size++] = emp;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + employees[i].getEmployeeId() + ", Name: " + employees[i].getName());
        }
    }

    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null; // help GC
    }

    public int getSize() {
        return size;
    }
}
