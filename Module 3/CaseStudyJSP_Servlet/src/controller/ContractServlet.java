package controller;

import dao.IContractDao;
import dao.ICustomerDao;
import dao.IEmployeeDao;
import dao.IServiceDao;
import dao.impl.ContractDaoImpl;
import dao.impl.CustomerDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.ServiceDaoImpl;
import model.*;

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
    private IEmployeeDao employeeDao;
    private ICustomerDao customerDao;
    private IServiceDao serviceDao;

    @Override
    public void init() {
        contractDao = new ContractDaoImpl();
        employeeDao = new EmployeeDaoImpl();
        customerDao = new CustomerDaoImpl();
        serviceDao = new ServiceDaoImpl();
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
                updateContract(req,resp);
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

    private void updateContract(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        
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

        String contract_start_date = req.getParameter("contract_start_date");
        String contract_end_date = req.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(req.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(req.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(req.getParameter("employee_id"));
        String customer_id = req.getParameter("customer_id");
        String service_id =req.getParameter("service_id");

        Contract contract = new Contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,
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
                showCreateContrat(req,resp);
                break;
            case "edit":
                
                break;
            case "delete":
                
                break;
            case "contract_details":
                showContractDetailsForm(req,resp);
                break;
            case "details":
                details(req,resp);
                break;
            default:
                listContract(req,resp);
                break;
        }
    }

    private void showCreateContrat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("contract/create.jsp");

        List<Employee> employeeList = employeeDao.getAllEmployee();
        List<Customer> customerList = customerDao.getAllCustomer();
        List<Service> serviceList = serviceDao.getAllService();


        req.setAttribute("employeeList",employeeList);
        req.setAttribute("customerList",customerList);
        req.setAttribute("serviceList",serviceList);

        dispatcher.forward(req,resp);
    }

    private void details(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        Contract contract = contractDao.getContract(id);

        Contract_details contract_details = contractDao.getContracDetails(id);

        Attach_service attach_service = contractDao.getAttachService(contract_details.getAttach_service_id());

        RequestDispatcher  dispatcher = req.getRequestDispatcher("contract/view.jsp");

        req.setAttribute("contract",contract);
        req.setAttribute("contract_details", contract_details);
        req.setAttribute("attach_service",attach_service);

        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showContractDetailsForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Attach_service> attachServiceList =contractDao.getAllAttachService();


        RequestDispatcher dispatcher= req.getRequestDispatcher("contract_details/create.jsp");

        req.setAttribute("attachServiceList", attachServiceList);
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
