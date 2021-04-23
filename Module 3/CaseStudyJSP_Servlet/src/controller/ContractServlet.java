package controller;

import dao.IContractDao;
import dao.impl.ContractDaoImpl;
import model.Contract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/contracts" , name = "contract")
public class ContractServlet extends HttpServlet {
    private IContractDao contractDao;

    @Override
    public void init() throws ServletException {
        contractDao = new ContractDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
                listContract(req,resp);
                break;
        }
    }

    private void listContract(HttpServletRequest req, HttpServletResponse resp) {
        List<Contract> contractList = contractDao.getAllContract();

        RequestDispatcher dispatcher = req.getRequestDispatcher("contract/list.jsp");
        req.setAttribute("contracts", contractList);

        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }

    }
}
