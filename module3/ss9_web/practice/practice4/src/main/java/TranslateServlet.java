import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txtSearch");
        TreeMap<String, String> dictionary = new TreeMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "Quyen Sach");
        dictionary.put("computer", "May tinh");
        Set<String> keys = dictionary.keySet();
        String str;
        if (keys.contains(txtSearch)) {
            str = dictionary.get(txtSearch);
        } else {
            str = "Khong co trong tu dien";
        }
        request.setAttribute("result", str);
        request.setAttribute("english", txtSearch);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
