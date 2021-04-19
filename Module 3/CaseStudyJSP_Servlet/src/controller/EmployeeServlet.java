package controller;

import dao.IEmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.Employee;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/employees" , name = "employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            default:
                listEmployee(req,resp);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) {
        List<Employee> employeeList = employeeDao.getAllEmployee();
        req.setAttribute("employees", employeeList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/list.jsp");

        try {
            dispatcher.forward(req,resp);  //bug
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createEmployee(req,resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            default:

                break;
        }
    }

    private void createEmployee(HttpServletRequest req, HttpServletResponse resp) {
        String employee_name = req.getParameter("employee_name");
        String employee_birthday = req.getParameter("employee_birthday");
        String employee_id_card = req.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(req.getParameter("employee_salary"));
        String employee_phone = req.getParameter("employee_phone");
        String employee_email = req.getParameter("employee_email");
        String employee_address = req.getParameter("employee_address");
        int position_id = Integer.parseInt(req.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(req.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(req.getParameter("division_id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Employee employee = new Employee(employee_name,employee_birthday,employee_id_card,employee_salary
        ,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);

        User user = new User(username,password);

        employeeDao.insertUser(user);
        employeeDao.insertEmployee(employee);

        listEmployee(req,resp);
    }
}
