package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Department get(int id) {
        LOGGER.info("Start get department {}", id);
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.getEmployeeList().size(); // force initialization of lazy collection
        }
        return department;
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start save department");
        departmentRepository.save(department);
        LOGGER.info("End save department");
    }
}
