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
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        customer.setName(request.getParameter("name"));
        String nameCustomerType = request.getParameter("nameCustomerType");
        customer.setNameCustomerType(nameCustomerType);
        String customerType;
        switch (nameCustomerType){
            case "Diamond":
                customerType = "1";
                break;
            case "Platinium":
                customerType = "2";
                break;
            case "Gold":
                customerType = "3";
                break;
            case "Silver":
                customerType = "4";
                break;
            default:
                customerType = "5";
                break;
        }
        customer.setCustomerType(customerType);
        boolean check = customerService.edit(id, customer);
        customer.setBirthday(request.getParameter("birthday"));
        customer.setGender(request.getParameter("gender"));
        customer.setIdCard(request.getParameter("idCard"));
        customer.setPhoneNumber(request.getParameter("phoneNumber"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        displayList(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("deleteId");
        boolean checkRemove = customerService.remove(id);
        displayList(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        request.setAttribute("customer", customer);

        try {
            request.getRequestDispatcher("furama/customer-edit-form.jsp").forward(request, response);
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
