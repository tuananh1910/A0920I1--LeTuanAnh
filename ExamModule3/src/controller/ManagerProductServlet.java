package controller;

import dao.ICustomerDao;
import dao.IManager_productDao;
import dao.impl.CustomerImpl;
import dao.impl.Manager_ProductDaoImpl;
import model.Customer;
import model.Manager_prodcut;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ManagerProductServlet extends HttpServlet {
    private IManager_productDao manager_productDao;
    @Override
    public void init() throws ServletException {
        manager_productDao = new Manager_ProductDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(req,resp);
                break;
            case "edit":

                break;
            case "delete":

                break;

            default:
                listProdcut(req, resp);
                break;
        }
    }

    private void showCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(req,resp);
    }

    private void listProdcut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manager_prodcut> managerProdcutList;

        managerProdcutList = manager_productDao.getAllProduct();


        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        req.setAttribute("products", managerProdcutList);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String product_name = req.getParameter("product_name");
            double product_price = Double.parseDouble(req.getParameter("product_price"));
            int product_discount = Integer.parseInt(req.getParameter("product_discount"));

            Manager_prodcut manager_prodcut = new Manager_prodcut(product_name,product_price,product_discount);

        System.out.println(manager_prodcut.getProduct_discount());


            manager_productDao.insertProduct(manager_prodcut);



            RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
            req.setAttribute("message", "Product was addded");
            dispatcher.forward(req,resp);

    }
}
