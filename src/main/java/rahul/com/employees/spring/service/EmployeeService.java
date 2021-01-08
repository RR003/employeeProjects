package rahul.com.employees.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rahul.com.employees.spring.dao.EmployeeRepository;
import rahul.com.employees.spring.model.Employee;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(int empNo, String password) {
        Employee employee = employeeRepository.findByEmpNoAndPassword(empNo, password);

        return employee;
    }
    @Override
    public Employee getEmployeeList(String firstName, String lastName){
        Employee allByFullName = employeeRepository.findAllByFirstNameAndLastName(firstName, lastName);
        return allByFullName;
    }
    @Override
    public Employee getFullEmployeeList(String firstName, String lastName, int empNo) {
        return employeeRepository.findAllByFirstNameAndLastNameAndEmpNo(firstName, lastName, empNo);
    }

    @Override
    public Employee getUltimateList(String firstName, String lastName, int empNo, String gender, String hireDate, String password){

        Employee employee = employeeRepository.findALLByFirstNameAndLastNameAndEmpNoAndGenderAndHireDate(firstName, lastName, empNo,
                                                                                            gender, hireDate);
        employee.setPassword(password);
        employeeRepository.save(employee);

        return employee;
    }
}
