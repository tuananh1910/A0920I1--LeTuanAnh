package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/discount",name = "discount cal")
public class Discount_Cal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float list_price = Float.parseFloat(req.getParameter("list_price"));
        float discount_percent = Float.parseFloat(req.getParameter("discount_percent"));

        double discount_amount = (list_price * discount_percent * 0.01);

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("Discount Amount"+discount_amount);
        writer.println("<br>");
        writer.println("Discount Price" + (list_price-discount_amount));
        writer.println("</html>");
    }
}
