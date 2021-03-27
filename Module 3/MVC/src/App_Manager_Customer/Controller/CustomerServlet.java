package App_Manager_Customer.Controller;

import App_Manager_Customer.Model.Customer;
import App_Manager_Customer.Service.CustomerServices;
import App_Manager_Customer.Service.CustomerServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customer" , name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerServices customerServices = new CustomerServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");

        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deleteForm(req,resp);
                break;
            case "view":
                viewForm(req,resp);
                break;
            default:
                listCustomers(req,resp);
                break;
        }
    }

    private void viewForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerServices.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("customer/view.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerServices.findById(id);
        RequestDispatcher dispatcher;
        if (customer==null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }
        else {
            req.setAttribute("customer", customer);
            dispatcher =req.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerServices.findById(id);
        RequestDispatcher dispatcher ;
        if (customer==null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }
        else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher= req.getRequestDispatcher("customer/create.jsp");

        try {
            dispatcher.forward(req,resp);
        }catch (ServletException | IOException se){
            se.printStackTrace();
        }
    }

    private void listCustomers(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customers = this.customerServices.findAll();
        req.setAttribute("customer", customers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");

        if (action== null){
            action="";
        }
        switch (action){
            case "create":
                createCustomer(req,resp);
                break;
            case "edit":
                updateCustomer(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerServices.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            this.customerServices.remove(id);
        }
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = this.customerServices.findById(id);
        RequestDispatcher dispatcher;
        if (customer==null){
            dispatcher= req.getRequestDispatcher("error-404.jsp");
        }
        else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerServices.update(id,customer);
            req.setAttribute("customer",customer);
            req.setAttribute("message", "Customer information was updated");
            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    static int id_static=0;
    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        int id=id_static+1;

        Customer customer = new Customer(id,name,email,address);

        this.customerServices.save(customer);
        RequestDispatcher dispatcher= req.getRequestDispatcher("customer/create.jsp");
        req.setAttribute("message", "Succesfully");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
