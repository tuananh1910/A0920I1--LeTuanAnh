package controller;

import dao.IContractDao;
import dao.impl.ContractDaoImpl;
import model.Contract;
import model.Contract_details;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createContract(req,resp);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "contract_details":
                AddContractDetails(req,resp);
                break;
            default:
                listContract(req,resp);
                break;
        }
    }

    private void AddContractDetails(HttpServletRequest req, HttpServletResponse resp) {
        int contract_id = Integer.getInteger(req.getParameter("contract_id"));

        int attach_service_id = Integer.parseInt(req.getParameter("attach_serivce_id"));
        int quality =Integer.parseInt(req.getParameter("quality"));

        Contract_details contract_details = new Contract_details(contract_id,attach_service_id,quality);
        contractDao.insertContractDetails(contract_details);



        RequestDispatcher dispatcher = req.getRequestDispatcher("contract_details/create.jsp");
        req.setAttribute("message","Succeful");
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest req, HttpServletResponse resp) {
        int contract_id = Integer.parseInt(req.getParameter("contract_id"));
        String contract_start_date = req.getParameter("contract_start_date");
        String contract_end_date = req.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(req.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(req.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(req.getParameter("employee_id"));
        int customer_id = Integer.parseInt(req.getParameter("customer_id"));
        int service_id = Integer.parseInt(req.getParameter("service_id"));

        Contract contract = new Contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,
                employee_id,customer_id,service_id);

        contractDao.insertContract(contract);

        listContract(req,resp);
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
            case "contract_details":
                showContractDetailsForm(req,resp);
                break;
            default:
                listContract(req,resp);
                break;
        }
    }

    private void showContractDetailsForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        RequestDispatcher dispatcher= req.getRequestDispatcher("contract_details/create.jsp");

        req.setAttribute("id", id);

        try{
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
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
