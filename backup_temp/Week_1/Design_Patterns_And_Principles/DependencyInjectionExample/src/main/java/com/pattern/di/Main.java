package com.pattern.di;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Pattern Execution Output ===");
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        
        System.out.println("Retrieving Customer 101:");
        String name101 = service.getCustomerName(101);
        System.out.println("Customer Name (101): " + name101);
        
        System.out.println("\nRetrieving Customer 999:");
        String name999 = service.getCustomerName(999);
        System.out.println("Customer Name (999): " + name999);
    }
}
