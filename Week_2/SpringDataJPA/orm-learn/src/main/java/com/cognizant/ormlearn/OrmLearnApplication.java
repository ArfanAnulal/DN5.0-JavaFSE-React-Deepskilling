package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static StockService stockService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        String mode = System.getProperty("mode", "june18");
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        if ("june17".equalsIgnoreCase(mode)) {
            System.out.println("=== Spring Data JPA & Hibernate Execution Output (June 17) ===");
            System.out.println("\n--- 1. Testing Get All Countries ---");
            testGetAllCountries();
            System.out.println("\n--- 2. Testing Find Country By Code (IN) ---");
            testFindCountryByCode("IN");
            System.out.println("\n--- 3. Testing Find Country By Code (Invalid Code: XX) ---");
            testFindCountryByCode("XX");
            System.out.println("\n--- 4. Testing Add Country (FR, France) ---");
            testAddCountry();
            System.out.println("\n--- 5. Testing Update Country (FR -> French Republic) ---");
            testUpdateCountry();
            System.out.println("\n--- 6. Testing Delete Country (FR) ---");
            testDeleteCountry();
            System.out.println("\n--- 7. Testing Find Countries Containing 'ou' ---");
            testFindCountriesContaining("ou");
            System.out.println("\n--- 8. Testing Find Countries Containing 'ou' Ordered By Name Asc ---");
            testFindCountriesContainingOrderByNameAsc("ou");
            System.out.println("\n--- 9. Testing Find Countries Starting with 'Z' ---");
            testFindCountriesStartingWith("Z");
            System.out.println("\n--- 10. Testing Facebook Sept 2019 Stocks ---");
            testFacebookSept2019();
            System.out.println("\n--- 11. Testing Google close price > 1250 Stocks ---");
            testGoogleAbove1250();
            System.out.println("\n--- 12. Testing Top 3 Highest Volume Stocks ---");
            testTop3HighestVolume();
            System.out.println("\n--- 13. Testing Top 3 Lowest Netflix Stocks ---");
            testTop3LowestNetflix();
        } else {
            System.out.println("=== Spring Data JPA & Hibernate Execution Output (June 18) ===");
            System.out.println("\n--- 1. Testing Get Employee (ID: 1) ---");
            testGetEmployee();

            System.out.println("\n--- 2. Testing Add Employee ---");
            testAddEmployee();

            System.out.println("\n--- 3. Testing Update Employee ---");
            testUpdateEmployee();

            System.out.println("\n--- 4. Testing Get Department (ID: 1) ---");
            testGetDepartment();

            System.out.println("\n--- 5. Testing Add Skill to Employee ---");
            testAddSkillToEmployee();

            System.out.println("\n--- 6. Testing Get All Permanent Employees (HQL Fetch Join) ---");
            testGetAllPermanentEmployees();

            System.out.println("\n--- 7. Testing Get Average Salary (Department ID: 1) ---");
            testGetAverageSalary();

            System.out.println("\n--- 8. Testing Get All Employees (Native Query) ---");
            testGetAllEmployeesNative();
        }
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        System.out.println("All Countries size: " + countries.size());
        for (Country c : countries) {
            System.out.println("Code: " + c.getCode() + ", Name: " + c.getName());
        }
    }

    private static void testFindCountryByCode(String code) {
        try {
            Country country = countryService.findCountryByCode(code);
            System.out.println("Found Country: Code: " + country.getCode() + ", Name: " + country.getName());
        } catch (CountryNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void testAddCountry() {
        Country country = new Country("FR", "France");
        countryService.addCountry(country);
        try {
            Country fetched = countryService.findCountryByCode("FR");
            System.out.println("Added successfully: " + fetched);
        } catch (CountryNotFoundException e) {
            System.out.println("Exception adding: " + e.getMessage());
        }
    }

    private static void testUpdateCountry() {
        try {
            countryService.updateCountry("FR", "French Republic");
            Country fetched = countryService.findCountryByCode("FR");
            System.out.println("Updated successfully: " + fetched);
        } catch (CountryNotFoundException e) {
            System.out.println("Exception updating: " + e.getMessage());
        }
    }

    private static void testDeleteCountry() {
        countryService.deleteCountry("FR");
        try {
            countryService.findCountryByCode("FR");
            System.out.println("Failed to delete!");
        } catch (CountryNotFoundException e) {
            System.out.println("Deleted successfully: Country FR not found");
        }
    }

    private static void testFindCountriesContaining(String sub) {
        List<Country> countries = countryService.findByNameContaining(sub);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFindCountriesContainingOrderByNameAsc(String sub) {
        List<Country> countries = countryService.findByNameContainingOrderByNameAsc(sub);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFindCountriesStartingWith(String letter) {
        List<Country> countries = countryService.findByNameStartingWith(letter);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFacebookSept2019() {
        List<Stock> stocks = stockService.getFacebookSept2019();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testGoogleAbove1250() {
        List<Stock> stocks = stockService.getGoogleAbove1250();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testTop3HighestVolume() {
        List<Stock> stocks = stockService.getTop3HighestVolume();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testTop3LowestNetflix() {
        List<Stock> stocks = stockService.getTop3LowestNetflix();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testGetEmployee() {
        Employee employee = employeeService.get(1);
        if (employee != null) {
            System.out.println("Employee: " + employee.getName() + ", Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Skills: " + employee.getSkillList());
        } else {
            System.out.println("Employee with ID 1 not found");
        }
    }

    private static void testAddEmployee() {
        try {
            Employee employee = new Employee();
            employee.setName("David Miller");
            employee.setSalary(72000.00);
            employee.setPermanent(true);
            employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1996-07-20"));
            
            Department dept = departmentService.get(1); // IT
            employee.setDepartment(dept);

            employeeService.save(employee);
            System.out.println("Employee added successfully with ID: " + employee.getId());
        } catch (Exception e) {
            System.out.println("Exception adding employee: " + e.getMessage());
        }
    }

    private static void testUpdateEmployee() {
        Employee employee = employeeService.get(3); // Bob Johnson (IT)
        if (employee != null) {
            Department dept = departmentService.get(2); // Finance
            employee.setDepartment(dept);
            employeeService.save(employee);
            System.out.println("Updated successfully: Employee " + employee.getName() + " moved to department " + employee.getDepartment().getName());
        } else {
            System.out.println("Employee ID 3 not found");
        }
    }

    private static void testGetDepartment() {
        Department department = departmentService.get(1); // IT
        if (department != null) {
            System.out.println("Department: " + department.getName());
            // Fetch list in transaction context or show count if EAGER was set
            System.out.println("Employees in Department: " + (department.getEmployeeList() != null ? department.getEmployeeList().size() : 0));
        } else {
            System.out.println("Department ID 1 not found");
        }
    }

    private static void testAddSkillToEmployee() {
        Employee employee = employeeService.get(2); // Jane Smith
        Skill skill = skillService.get(2); // Spring Boot
        if (employee != null && skill != null) {
            Set<Skill> skills = employee.getSkillList();
            if (skills == null) {
                skills = new HashSet<>();
            }
            skills.add(skill);
            employee.setSkillList(skills);
            employeeService.save(employee);
            System.out.println("Skill " + skill.getName() + " added to Employee " + employee.getName());
        } else {
            System.out.println("Employee ID 2 or Skill ID 2 not found");
        }
    }

    private static void testGetAllPermanentEmployees() {
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        System.out.println("Permanent Employees size: " + employees.size());
        for (Employee e : employees) {
            System.out.println("Employee: " + e.getName() + ", Permanent: " + e.isPermanent() + ", Department: " + (e.getDepartment() != null ? e.getDepartment().getName() : "None") + ", Skills: " + e.getSkillList());
        }
    }

    private static void testGetAverageSalary() {
        double avg = employeeService.getAverageSalary(1);
        System.out.println("Average Salary in IT Department: " + avg);
    }

    private static void testGetAllEmployeesNative() {
        List<Employee> employees = employeeService.getAllEmployeesNative();
        System.out.println("All Employees (Native Query) size: " + employees.size());
        for (Employee e : employees) {
            System.out.println("Native Employee: " + e.getName() + ", Salary: " + e.getSalary());
        }
    }
}

