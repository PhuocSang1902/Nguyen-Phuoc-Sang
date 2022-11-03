import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value="/calculator")
public class CalculatorServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float firstOperand = Float.parseFloat(request.getParameter("fOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("sOperand"));
        String math = request.getParameter("math");
        Calculator calculator = new Calculator(firstOperand,secondOperand,math);

        request.setAttribute("calculator",calculator);
        request.getRequestDispatcher("Result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
