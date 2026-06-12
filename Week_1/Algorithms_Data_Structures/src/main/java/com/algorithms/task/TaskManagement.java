package com.algorithms.task;

public class TaskManagement {
    private Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Task ID: " + temp.task.getTaskId() + ", Name: " + temp.task.getTaskName());
            temp = temp.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null && !curr.task.getTaskId().equals(taskId)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            throw new IllegalArgumentException("Task not found with ID: " + taskId);
        }
        prev.next = curr.next;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
