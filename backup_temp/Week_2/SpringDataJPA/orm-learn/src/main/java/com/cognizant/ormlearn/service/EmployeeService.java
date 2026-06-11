package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee get(int id) {
        LOGGER.info("Start get employee {}", id);
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.getSkillList().size(); // force initialization of lazy collection
        }
        return employee;
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start save employee");
        employeeRepository.save(employee);
        LOGGER.info("End save employee");
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start getAllPermanentEmployees");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int departmentId) {
        LOGGER.info("Start getAverageSalary for department {}", departmentId);
        return employeeRepository.getAverageSalary(departmentId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Start getAllEmployeesNative");
        return employeeRepository.getAllEmployeesNative();
    }
}
