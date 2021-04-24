package controller;

import dao.IEmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.*;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            case "views":
                showviewForm(req,resp);
                break;
            default:
                listEmployee(req,resp);
                break;
        }
    }

    private void showviewForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/view.jsp");
        req.setAttribute("employee", employee);

        try{
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);

        Position position = employeeDao.getPosition(employee.getPosition_id());
        Education_Degree education_degree = employeeDao.getEducationDegree(employee.getEducation_degree_id());
        Division division = employeeDao.getDivision(employee.getDivision_id());

        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/delete.jsp");


        req.setAttribute("employee", employee);
        req.setAttribute("position" , position);
        req.setAttribute("education_degree",education_degree);
        req.setAttribute("division",division);
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.getEmployee(id);
        req.setAttribute("employee" , employee);


        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/update.jsp");

        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createEmployee(req,resp);
                break;
            case "edit":
                editEmployee(req,resp);
                break;
            case "delete":
                deleteEmployee(req,resp);
                break;
            default:
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
            int id = Integer.parseInt(req.getParameter("employee_id"));
            Employee employee = employeeDao.getEmployee(id);

            RequestDispatcher dispatcher;

            try {
                if (employeeDao.deleteEmployee(id)){
//                    employeeDao.deleteUser(employee.getUsername());
                    dispatcher = req.getRequestDispatcher("employee/delete.jsp");
                    req.setAttribute("message","Employee was deleted");
                }else {
                    dispatcher = req.getRequestDispatcher("error-404.jsp");
                }
                dispatcher.forward(req,resp);
            }catch (ServletException|IOException e){
                e.printStackTrace();
            }
    }

    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("employee_id"));
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



        Employee update_employee = new Employee(id,employee_name,employee_birthday,employee_id_card
        ,employee_salary,employee_phone,employee_email,employee_address,position_id,
                education_degree_id,division_id);

        RequestDispatcher dispatcher ;
        try {
            if (employeeDao.updateEmployee(update_employee)){

                dispatcher = req.getRequestDispatcher("employee/update.jsp");
                req.setAttribute("message","Succesful");
            }else {
                dispatcher = req.getRequestDispatcher("error-404.jsp");
            }
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
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
        int role_id = Integer.parseInt(req.getParameter("role_id"));

        Employee employee = new Employee(employee_name,employee_birthday,employee_id_card,employee_salary
        ,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);

        User user = new User(username,password);

        User_role user_role = new User_role(role_id,username);

        employeeDao.insertUserRole(user_role);
        employeeDao.insertUser(user);
        employeeDao.insertEmployee(employee);

        listEmployee(req,resp);
    }
}
