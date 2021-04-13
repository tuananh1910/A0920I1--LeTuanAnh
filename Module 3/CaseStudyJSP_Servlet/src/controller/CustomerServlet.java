package controller;

import dao.ICustomerDao;
import dao.impl.CustomerDaoImpl;
import model.Customer;
import model.Customer_Type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ="/customers",name = "customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerDao customerDao;

    @Override
    public void init() {
        customerDao=new CustomerDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                break;
            default:
                listCustomer(req,resp);
                break;
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDao.getCustomer(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/update.jsp");
        req.setAttribute("customer", customer);
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customers=customerDao.getAllCustomer();
        req.setAttribute("customers",customers);
        RequestDispatcher dispatcher=req.getRequestDispatcher("customer/list.jsp");
        try{
            dispatcher.forward(req,resp);
        }catch (ServletException |IOException e){
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
                break;
            case "edit":
                UpdateCustomer(req,resp);
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void UpdateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int customer_id = Integer.parseInt(req.getParameter("customer_id"));
        String customer_type_name = req.getParameter("customer_type");
        int customer_type_id = 0;
        String customer_name = req.getParameter("customer_name");
        String customer_birthday = req.getParameter("customer_birthday");
        String customer_gender = req.getParameter("customer_gender");
        String customer_id_card = req.getParameter("customer_id_card");
        String customer_phone = req.getParameter("customer_phone");
        String customer_email = req.getParameter("customer_email");
        String customer_address = req.getParameter("customer_address");

        List<Customer_Type> customer_types = customerDao.getAllCustomerType();
        for (Customer_Type value : customer_types){
            System.out.println(value.getCustomer_type_name());
            if (value.getCustomer_type_name().equals(customer_type_name)){
                customer_type_id = value.getCustomer_type_id();
                break;
            }
        }

        Customer customer = new Customer(customer_id,customer_type_id,customer_name,customer_birthday
        ,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);

        RequestDispatcher dispatcher;
        try {
            if (customerDao.upodateCustomer(customer)){
                dispatcher =  req.getRequestDispatcher("customer/update.jsp");
                    req.setAttribute("message", "Successful");
            }else {
                dispatcher = req.getRequestDispatcher("error-404.jsp");
            }
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }
}
