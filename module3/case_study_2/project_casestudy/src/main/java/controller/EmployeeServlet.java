package controller;

import model.customer.Customer;
import model.employee.Employee;
import service.IEmployeeService;
import service.impl.employee.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private IEmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "remove":
                remove(request, response);
                break;
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("deleteId");
        boolean checkRemove = false;
        if(id != null){
            checkRemove = employeeService.remove(id);
        }
        String mess;
        if (checkRemove){
            mess= "Chỉnh sửa thành công";
        }else {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
        displayList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "display":
                displayList(request, response);
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
        List<Employee> employeeList = employeeService.search(search);
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.getList();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
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
