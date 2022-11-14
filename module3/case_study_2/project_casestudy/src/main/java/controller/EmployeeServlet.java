package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.Employee;
import service.IEmployeeService;
import service.impl.employee.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
            case "edit":
                edit(request, response);
                break;
            case "add":
                add(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        employee.setName(request.getParameter("name"));
        employee.setBirthday(request.getParameter("birthday"));
        employee.setIdCard(request.getParameter("idCard"));
        employee.setSalary(request.getParameter("salary"));
        employee.setPhoneNumber(request.getParameter("phoneNumber"));
        employee.setEmail(request.getParameter("email"));
        employee.setAddress(request.getParameter("address"));
        employee.setPositionId(request.getParameter("positionId"));
        employee.setEducationDegreeId(request.getParameter("educationDegreeId"));
        employee.setDivisionId(request.getParameter("divisionId"));
        boolean checkEdit = employeeService.edit(id, employee);
        String mess;
        if (checkEdit){
            mess= "Chỉnh sửa thành công";
        }else {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
        displayList(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String positionId = request.getParameter("positionId");
        String educationDegreeId = request.getParameter("educationDegreeId");
        String divisionId = request.getParameter("divisionId");
        Employee employee = new Employee(name, birthday, idCard, salary, phoneNumber, email, address, positionId,educationDegreeId,divisionId);
        Map<String, String> errorMap = employeeService.add(employee);
        String mess;
        if (errorMap.isEmpty()){
            mess= "Thêm mới thành công";
        }else {
            mess = "Thêm mới không thành công";
            LocalDate nowDate = LocalDate.now();
            int nowYear = nowDate.getYear();
            LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
            request.setAttribute("nowDate", nowDate);
            request.setAttribute("nowDateEndYear", nowDateEndYear);
            request.setAttribute("errorMap", errorMap);
            request.setAttribute("employee", employee);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/employee/add-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
