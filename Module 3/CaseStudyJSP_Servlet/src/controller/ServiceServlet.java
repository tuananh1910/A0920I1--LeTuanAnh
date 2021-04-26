package controller;

import dao.IServiceDao;
import dao.impl.ServiceDaoImpl;
import model.Rent_type;
import model.Service;
import model.Service_type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/services", name = "services")
public class ServiceServlet extends HttpServlet {
    private IServiceDao serviceDao;
    @Override
    public void init() throws ServletException {
        serviceDao = new ServiceDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action== null){
            action="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "details":
                details(req,resp);
                break;
            default:
                listService(req,resp);
                break;
        }
    }

    private void details(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Service service = serviceDao.getService(id);

        Service_type service_type = serviceDao.getServiceType(service.getService_type_id()) ;
        Rent_type rent_type = serviceDao.getRentType(service.getRent_type_id());

        req.setAttribute("service", service);
        req.setAttribute("service_type",service_type);
        req.setAttribute("rent_type", rent_type);

        RequestDispatcher dispatcher = req.getRequestDispatcher("service/view.jsp");
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest req, HttpServletResponse resp) {
        List<Service> serviceList = serviceDao.getAllService();

        RequestDispatcher dispatcher = req.getRequestDispatcher("service/list.jsp");
        req.setAttribute("services",serviceList);

        try {
            dispatcher.forward(req,resp);
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

                break;
            case "edit":

                break;
            case "delete":

                break;
            default:

                break;
        }
    }
}
