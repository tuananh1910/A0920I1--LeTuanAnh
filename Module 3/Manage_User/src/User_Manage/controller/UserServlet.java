package User_Manage.controller;

import User_Manage.dao.IUserDAO;
import User_Manage.dao.UserDAO;
import User_Manage.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users", name = "user")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO;

    @Override
    public void init() {
         userDAO =new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                createUserForm(req,resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listUsers(req,resp);
                break;
        }
    }

    private void createUserForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userDAO.selectAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
        try{
            dispatcher.forward(req,resp);
        }catch (ServletException |IOException e){
            e.printStackTrace();
        }
    }
}
