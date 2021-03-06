package controller;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import dao.IContractDao;
import dao.ICustomerDao;
import dao.impl.ContractDaoImpl;
import dao.impl.CustomerDaoImpl;
import model.Contract;
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
    private IContractDao contractDao;

    @Override
    public void init() {
        customerDao=new CustomerDaoImpl();
        contractDao = new ContractDaoImpl();
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
            case "details":
                details(req,resp);
                break;
            default:
                listCustomer(req,resp);
                break;
        }
    }

    private void details(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Customer customer = customerDao.getCustomer(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/view.jsp");
        req.setAttribute("customer",customer);

        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
//        List<Customer_Type> customerTypeList = customerDao.getAllCustomerType();

        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
//        req.setAttribute("customerTypeList", customerTypeList);
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Customer customer = customerDao.getCustomer(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/delete.jsp");
        req.setAttribute("customer", customer);
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Customer customer = customerDao.getCustomer(id);
        Customer_Type customer_type = customerDao.getCustomerType(customer.getCustomer_type_id());
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/update.jsp");
        req.setAttribute("customer", customer);
        req.setAttribute("customer_type", customer_type);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createCustomer(req,resp);
                break;
            case "edit":
                UpdateCustomer(req,resp);
                break;
            case "delete":
                DeleteCustomer(req,resp);
                break;
            default:
                break;
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String customer_id = req.getParameter("customer_id");
        int customer_type_id = Integer.parseInt(req.getParameter("customer_type_id"));
        String customer_name = req.getParameter("customer_name");
        String customer_birthday = req.getParameter("customer_birthday");
        System.out.println(customer_birthday);
        String customer_gender = req.getParameter("customer_gender");
        String customer_id_card = req.getParameter("customer_id_card");
        String customer_phone = req.getParameter("customer_phone");
        String customer_email = req.getParameter("customer_email");
        String customer_address = req.getParameter("customer_address");

        Customer customer = new Customer(customer_id,customer_type_id,customer_name,customer_birthday
        ,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);

        customerDao.insertCustomer(customer);
        listCustomer(req,resp);

    }

    private void DeleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("customer_id");

        RequestDispatcher dispatcher;
        Contract contract = contractDao.getContractByCustomerId(id);
        List<Contract> contractList = contractDao.getAllContract();
        try {
            if (customerDao.deleteCustomer(id)){
                for (Contract value : contractList){
                    if (value.getCustomer_id().equals(id)){
                        contractDao.deleteContractByCustomerID(id);
                        contractDao.deleteContratDetailsByContractID(contract.getContract_id());
                    }
                }

                dispatcher =req.getRequestDispatcher("customer/delete.jsp");
                req.setAttribute("message" ,"Customer was Deleted");
            }else {
                dispatcher =req.getRequestDispatcher("error-404.jsp");
            }
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void UpdateCustomer(HttpServletRequest req, HttpServletResponse resp) {

        String id = req.getParameter("customer_id");
        int customer_type_id = Integer.parseInt(req.getParameter("customer_type_id"));



        String customer_name = req.getParameter("customer_name");
        String customer_birthday = req.getParameter("customer_birthday");

        String customer_gender = req.getParameter("customer_gender");


        String customer_id_card = req.getParameter("customer_id_card");
        String customer_phone = req.getParameter("customer_phone");
        String customer_email = req.getParameter("customer_email");
        String customer_address = req.getParameter("customer_address");


        Customer customer = new Customer(id,customer_type_id,customer_name,customer_birthday
        ,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);

        RequestDispatcher dispatcher;
        try {
            if (customerDao.updateCustomer(customer)){
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
