package rahul.com.employees.spring.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rahul.com.employees.spring.model.Employee;

import javax.transaction.Transactional;
import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    public Employee findAllByFirstNameAndLastName(String firstName, String lastName);
    // select * from employees where first_name = ? and last_name = ?

    public Employee findByEmpNoAndPassword(int empNo, String password); /// select  * from employees where id = ?

    public Employee findAllByFirstNameAndLastNameAndEmpNo(String firstName, String lastName, int empNo);
    public Employee findALLByFirstNameAndLastNameAndEmpNoAndGenderAndHireDate(String firstName, String lastName,
                                                                                    int empNo, String gender, String hireDate);

}
