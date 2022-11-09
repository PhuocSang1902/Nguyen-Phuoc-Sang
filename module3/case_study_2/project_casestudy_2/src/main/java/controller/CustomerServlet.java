package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "remove":
                remove(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "add":
                add(request, response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String customerType = request.getParameter("customerType");
        String nameCustomerType;
        switch (customerType){
            case "1":
                nameCustomerType = "Diamond";
                break;
            case "2":
                nameCustomerType = "Platinum";
                break;
            case "3":
                nameCustomerType = "Gold";
                break;
            case "4":
                nameCustomerType = "Silver";
                break;
            default:
                nameCustomerType = "Member";
                break;
        }
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, customerType, nameCustomerType, birthday, gender, idCard, phoneNumber, email, address);
        boolean checkAdd = customerService.add(customer);
        String mess;
        if (checkAdd){
            mess= "Thêm mới thành công";
        }else {
            mess = "Thêm mới không thành công";
        }
        request.setAttribute("mess", mess);
        displayList(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        customer.setName(request.getParameter("name"));
        String customerType = request.getParameter("customerType");
        customer.setCustomerType(customerType);
        String nameCustomerType;
        switch (customerType){
            case "1":
                nameCustomerType = "Diamond";
                break;
            case "2":
                nameCustomerType = "Platinum";
                break;
            case "3":
                nameCustomerType = "Gold";
                break;
            case "4":
                nameCustomerType = "Silver";
                break;
            default:
                nameCustomerType = "Member";
                break;
        }
        customer.setNameCustomerType(nameCustomerType);
        customer.setBirthday(request.getParameter("birthday"));
        customer.setGender(request.getParameter("gender"));
        customer.setIdCard(request.getParameter("idCard"));
        customer.setPhoneNumber(request.getParameter("phoneNumber"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));
        boolean checkEdit = customerService.edit(id, customer);
        String mess;
        if (checkEdit){
            mess= "Chỉnh sửa thành công";
        }else {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
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
            case "search":
                search(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> customerList = customerService.search(search);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("furama/customer-list.jsp").forward(request, response);
            response.sendRedirect("/customer?action=search");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<CustomerType> customerTypeList = customerTypeService.getList();
        Customer customer = customerService.findById(id);
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("nowDate", nowDate);
        request.setAttribute("nowDateEndYear", nowDateEndYear);

        try {
            request.getRequestDispatcher("furama/customer-edit-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.getList();
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
        request.setAttribute("nowDate", nowDate);
        request.setAttribute("nowDateEndYear", nowDateEndYear);
        request.setAttribute("customerTypeList", customerTypeList);

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
