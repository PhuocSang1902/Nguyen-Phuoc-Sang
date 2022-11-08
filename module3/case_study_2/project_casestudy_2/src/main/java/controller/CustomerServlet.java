package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "remove":
                remove(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        boolean checkRemove = customerService.remove(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "display":
                displayList(request, response);
                break;
            case "add":
                displayAddForm(request, response);
                break;
            case "edit":
                displayEditForm(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerService.findById(id);

        request.setAttribute("customer", customer);

        try {
            request.getRequestDispatcher("furama/customer-edit-form").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAddForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("furama/customer-add-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.getList();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("furama/customer-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayHomePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
