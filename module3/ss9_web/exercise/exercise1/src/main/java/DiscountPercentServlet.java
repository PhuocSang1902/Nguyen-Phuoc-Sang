import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountPercentServlet", value = "/discount_amount")
public class DiscountPercentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("listPrice"));
        float percent = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = price * percent * 0.01f;
        float priceAfter = price - discountAmount;
        String discountAmountStr = String.format("%.0f", discountAmount);
        String priceAfterStr = String.format("%.0f", priceAfter);

        request.setAttribute("discountAmount", discountAmountStr);
        request.setAttribute("priceAfter", priceAfterStr);
        request.setAttribute("product", product);
        request.getRequestDispatcher("result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
