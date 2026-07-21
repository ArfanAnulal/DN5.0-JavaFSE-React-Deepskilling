package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    public static ArrayList<Department> DEPARTMENT_LIST = new ArrayList<>();

    public DepartmentDao() {
        if (DEPARTMENT_LIST.isEmpty()) {
            try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml")) {
                @SuppressWarnings("unchecked")
                ArrayList<Department> list = (ArrayList<Department>) context.getBean("departmentList");
                DEPARTMENT_LIST.addAll(list);
            }
        }
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
