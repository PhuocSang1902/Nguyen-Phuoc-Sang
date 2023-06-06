import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer-list")
public class CustomerServlet extends HttpServlet {

    static private List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Mai Van Hoang", "1983-08-20", "Ha Noi", "https://vanhoaviet.net/wp-content/uploads/2020/07/hot-girl-anh-the-thanh-hang-02.jpg"));
        customerList.add(new Customer(1, "Nguyen Van Nam", "1983-08-21", "Bac Giang", "https://phunugioi.com/wp-content/uploads/2021/09/Mau-anh-the-dep-xin-viec.jpg"));
        customerList.add(new Customer(1, "Nguyen Thai Hoa", "1983-08-22", "Nam Dinh", "https://2sao.vietnamnetjsc.vn/images/2019/01/16/14/31/hotgirl-anh-the-02.jpg"));
        customerList.add(new Customer(1, "Tran Dang Khoa", "1983-08-17", "Ha Tay", "https://info-imgs.vgcloud.vn/2020/11/09/16/123022946-4049048075112120-8482462408024710286-o.jpg"));
        customerList.add(new Customer(1, "Nguyen Dinh Thi", "1983-08-19", "Ha Noi", "https://media.doisongphapluat.com/684/2020/8/12/xao-xuyen-ngan-ngo-truoc-net-dep-khong-goc-chet-cua-hotgirl-anh-the-nguoi-dan-toc-giay-dspl-7.jpg"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("custumer_list.jsp").forward(request, response);
    }
}
