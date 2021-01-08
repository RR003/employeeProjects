package rahul.com.employees.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import rahul.com.employees.spring.model.Employee;
import rahul.com.employees.spring.service.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"/employeeController"})
public class EmployeeControllerServlet extends HttpServlet {

    @Autowired
    private IEmployeeService employeeService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String firstName = req.getParameter("firstName");
        // String lastName = req.getParameter("lastName");
        String empNo = req.getParameter("empNo");
        String password = req.getParameter("password");

        Employee employeeInfo = null;


        employeeInfo = employeeService.getEmployee(Integer.parseInt(empNo), password);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeInfo);
        req.setAttribute("employeeList", employeeList);
        RequestDispatcher employeeView =req.getRequestDispatcher("employeeListView");
        employeeView.include(req, resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
