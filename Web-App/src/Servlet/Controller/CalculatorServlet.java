package Servlet.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        double first_number = Double.parseDouble(req.getParameter("first number"));
        double second_number = Double.parseDouble(req.getParameter("second number"));
        String operator = req.getParameter("operator");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("Result : " + Calculator.Calculator_Operator(first_number,second_number,operator));
        writer.println("</html>");


    }
}
