import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConvertServlet", value = "/convert")
public class ConvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double usd = Double.parseDouble(request.getParameter("usd"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double vnd = usd * rate;
        String str = String.format("%.0f", vnd);

        request.setAttribute("vnd",str);
        request.getRequestDispatcher("convert.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
