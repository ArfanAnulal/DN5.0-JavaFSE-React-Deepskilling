package com.pattern.di;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 101) {
            return "Jane Doe";
        }
        return "Customer Not Found";
    }
}
