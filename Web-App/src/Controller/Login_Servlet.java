package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login-sever" , name = "Login")
public class Login_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        if("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome "+username+" to website</h1>");

        } else{
            String contextPath = req.getContextPath();
            writer.println("<h1>Login Error</h1>");
            response.sendRedirect(contextPath + "/time-server");

            return;
        }

        writer.println("</html>");
    }
}
