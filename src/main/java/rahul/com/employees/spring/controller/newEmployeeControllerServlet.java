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

@WebServlet(name = "newServlet", urlPatterns = {"/newEmployeeController"})
public class newEmployeeControllerServlet extends HttpServlet{


        @Autowired
        private IEmployeeService employeeService;


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String empNo = req.getParameter("empNo");
            String oldgender = req.getParameter("gender");
            oldgender = oldgender.toUpperCase();
            String gender = oldgender.substring(0,1);
            String date = req.getParameter("hireDate");
            date.replace("/", "-");
            String password = req.getParameter("password");




            List<Employee> employeeList = new ArrayList<>();
            Employee employeeInfo = null;

            employeeInfo = employeeService.getUltimateList(firstName, lastName, Integer.parseInt(empNo), gender, date, password);
            employeeList.add(employeeInfo);
            req.setAttribute("employeeList", employeeList);
            RequestDispatcher employeeView = req.getRequestDispatcher("employeeListView");
            employeeView.include(req, resp);

            /*if (empNo != null && empNo.trim().length() > 0){
                employeeList = employeeService.getEmployee(Integer.parseInt(empNo));
                req.setAttribute("employeeList", employeeList);
                RequestDispatcher employeeView  =req.getRequestDispatcher("employeeListView");
                employeeView.include(req, resp);
            }else {
                // employeeList = employeeService.getFullEmployeeList(firstName, lastName, Integer.parseInt(empNo));
                req.setAttribute("employeeList", employeeList);
                RequestDispatcher employeeView = req.getRequestDispatcher("employeeListView");
                employeeView.include(req, resp);
            }*/

        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }
}
