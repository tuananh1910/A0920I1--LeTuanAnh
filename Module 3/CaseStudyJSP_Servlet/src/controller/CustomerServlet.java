package controller;

import dao.ICustomerDao;
import dao.impl.CustomerDaoImpl;
import model.Customer;

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
                break;
            case "delete":
                break;
            default:
                listCustomer(req,resp);
                break;
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

    }
}
