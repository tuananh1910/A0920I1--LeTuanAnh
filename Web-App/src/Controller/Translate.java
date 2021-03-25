package Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/translation" , name = "Translate")
public class Translate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello" ,"Xin Chao");
        dictionary.put("music","Nhac");
        dictionary.put("bye","Tam Biet");

        String search = req.getParameter("txtSearch"); //parameter -- name input


        PrintWriter writer = resp.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search.toLowerCase());
        if (result != null){
            writer.println("Word: " + search);
            writer.println("<br>");
            writer.println("Resulft: " + result);
        }
        else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }
}
