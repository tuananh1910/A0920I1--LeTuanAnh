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
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/users", name = "user")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewUser(req, resp);
                break;
            case "edit":
                updateUser(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            case "find":
                findByCountry(req, resp);
                break;
            default:
                break;
        }
    }

    private void findByCountry(HttpServletRequest req, HttpServletResponse resp) {
        String country = req.getParameter("country");
        List<User> users = userDAO.findByCountry(country);


        req.setAttribute("users", users);

        RequestDispatcher dispatcher;
        if (users.isEmpty()) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher=req.getRequestDispatcher("user/view.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher dispatcher ;
        try {
            if (userDAO.deleteUser(id)){
                dispatcher = req.getRequestDispatcher("user/delete.jsp");
                req.setAttribute("message", "User was deleted");
            }else {
                dispatcher = req.getRequestDispatcher("error-404.jsp");
            }
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.getSQLState();
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User updateUser = new User(id, name, email, country);
        RequestDispatcher dispatcher;

        try {
            if (userDAO.updateUser(updateUser)){
                dispatcher = req.getRequestDispatcher("user/edit.jsp");
                req.setAttribute("message", "Succesful");
            }else {
                dispatcher = req.getRequestDispatcher("error-404");
            }
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.getSQLState();
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void addNewUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(name, email, country);
        userDAO.insertUserStore(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
        req.setAttribute("message", "New User was added ");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUserForm(req, resp);
                break;
            case "edit":
                editUserForm(req, resp);
                break;
            case "delete":
                deleteUserForm(req, resp);
                break;
            case "find":
                findForm(req, resp);
                break;
            case "permision":
                addUserPermision(req, resp);
                break;
            case "test-without-tran":
                testWithoutTran(req, resp);
                break;
            case "test-use-tran":
                testUseTran(req, resp);
                break;
            default:
                listUsers(req, resp);
                break;
        }
    }

    private void testUseTran(HttpServletRequest req, HttpServletResponse resp) {
        userDAO.insertUpdateWithoutTransaction();
    }

    private void testWithoutTran(HttpServletRequest req, HttpServletResponse resp) {
        userDAO.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User("kien", "kienhoang@gmail.com", "viet nam");

        int[] permision = {1, 2, 4};

        userDAO.addUserTransaction(user, permision);

    }

    private void findForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/find.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUserForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userDAO.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/delete.jsp");
        req.setAttribute("user", user);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editUserForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userDAO.getUserById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/edit.jsp");
        req.setAttribute("user", user);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createUserForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userDAO.selectAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
