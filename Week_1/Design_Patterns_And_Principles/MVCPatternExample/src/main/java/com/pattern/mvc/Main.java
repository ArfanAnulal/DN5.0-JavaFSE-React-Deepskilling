package com.pattern.mvc;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MVC Pattern Execution Output ===");
        Student student = new Student();
        student.setName("Alice");
        student.setId("S101");
        student.setGrade("A");
        
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        
        System.out.println("Displaying initial student state:");
        controller.updateView();
        
        System.out.println("\nUpdating student details via controller:");
        controller.setStudentName("Bob");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
