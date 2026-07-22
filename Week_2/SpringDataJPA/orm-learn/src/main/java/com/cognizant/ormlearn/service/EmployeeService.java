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
        LOGGER.info("Fetching employee record for ID: {}", id);
        Employee emp = employeeRepository.findById(id).orElse(null);
        if (emp != null) {
            emp.getSkillList().size(); // Trigger lazy loading for skills
        }
        return emp;
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Saving employee entity: {}", employee.getName());
        employeeRepository.save(employee);
        LOGGER.info("Employee record saved successfully.");
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Querying all permanent employee records (HQL fetch join)...");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int departmentId) {
        LOGGER.info("Computing average salary for department ID: {}", departmentId);
        return employeeRepository.getAverageSalary(departmentId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Executing native SQL to retrieve all employee rows...");
        return employeeRepository.getAllEmployeesNative();
    }
}
