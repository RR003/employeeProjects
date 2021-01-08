package rahul.com.employees.spring.service;

import rahul.com.employees.spring.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee getEmployee(int empNo, String password);
    Employee getEmployeeList(String firstName, String lastName);
    Employee getFullEmployeeList(String firstName, String lastName, int empNo);
    Employee getUltimateList(String firstName, String lastName, int empNo, String gender, String hireDate, String password);
}
