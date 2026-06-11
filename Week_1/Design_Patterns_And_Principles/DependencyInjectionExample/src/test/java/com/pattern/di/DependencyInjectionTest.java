package com.pattern.di;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DependencyInjectionTest {
    @Test
    public void testDependencyInjection() {
        CustomerRepository mockRepo = new CustomerRepository() {
            @Override
            public String findCustomerById(int id) {
                return "Mocked Customer";
            }
        };

        CustomerService service = new CustomerService(mockRepo);
        String name = service.getCustomerName(999);
        assertEquals("Mocked Customer", name, "Dependency injection verification failed");
    }

    @Test
    public void testRealRepository() {
        CustomerRepository realRepo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(realRepo);
        
        assertEquals("Jane Doe", service.getCustomerName(101));
        assertEquals("Customer Not Found", service.getCustomerName(200));
    }
}
