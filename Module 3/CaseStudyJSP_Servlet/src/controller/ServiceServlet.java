package controller;

import dao.IServiceDao;
import dao.impl.ServiceDaoImpl;
import model.Service;

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
            default:
                listService(req,resp);
                break;
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
