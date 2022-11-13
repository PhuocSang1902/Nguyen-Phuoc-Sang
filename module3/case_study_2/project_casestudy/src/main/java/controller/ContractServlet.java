package controller;

import model.Facility.AttachFacility;
import model.Facility.Facility;
import model.contract.Contract;
import model.contract.ContractDetail;
import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.Employee;
import repository.impl.contract.ContractRepository;
import service.*;
import service.impl.contract.ContractDetailService;
import service.impl.contract.ContractService;
import service.impl.customer.CustomerService;
import service.impl.employee.EmployeeService;
import service.impl.facility.AttachFacilityService;
import service.impl.facility.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    private IContractService contractService = new ContractService();
    private IContractDetailService contractDetailService = new ContractDetailService();
    private ICustomerService customerService = new CustomerService();
    private IFacilityService facilityService = new FacilityService();
    private IEmployeeService employeeService = new EmployeeService();
    private IAttachFacilityService attachFacilityService = new AttachFacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayListAttachFacility":
                displayListAttachFacility(request, response);
                break;
            case "add":
                add(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String deposit = request.getParameter("deposit");
        String totalValue = request.getParameter("totalValue");
        String customerId = request.getParameter("customer");
        Customer customer = customerService.findById(Integer.parseInt(customerId));
        String facilityId = request.getParameter("facility");
        Facility facility = facilityService.findById(Integer.parseInt(facilityId));
        String employeeId = request.getParameter("employee");
        Employee employee = employeeService.findById(Integer.parseInt(employeeId));
        Contract contract = new Contract(startDate, endDate, deposit, employee, customer, facility);
        Map<String, String> errorMap = contractService.add(contract);
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
            List<Contract> contractList = contractService.getList();
            List<Customer> customerList = customerService.getList();
            List<Facility> facilityList = facilityService.getList();
            List<Employee> employeeList = employeeService.getList();
            request.setAttribute("contractList", contractList);
            request.setAttribute("customerList", customerList);
            request.setAttribute("facilityList", facilityList);
            request.setAttribute("employeeList", employeeList);
            request.setAttribute("totalValue", totalValue);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/contract/add-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            case "add":
                showAddForm(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;

        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.getList();
        List<Customer> customerList = customerService.getList();
        List<Facility> facilityList = facilityService.getList();
        List<Employee> employeeList = employeeService.getList();
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
        request.setAttribute("nowDate", nowDate);
        request.setAttribute("nowDateEndYear", nowDateEndYear);
        request.setAttribute("contractList", contractList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("facilityList", facilityList);
        request.setAttribute("employeeList", employeeList);

        try {
            request.getRequestDispatcher("view/contract/add-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayListAttachFacility(HttpServletRequest request, HttpServletResponse response) {
        String contractId = request.getParameter("contractId");
        List<ContractDetail> contractDetailList = contractDetailService.getListInContract(Integer.parseInt(contractId));
        Map<Contract, String> contractMap = contractService.getListWithValue();
        Set<Contract> contractList = contractMap.keySet();
        request.setAttribute("contractList", contractList);
        request.setAttribute("contractMap", contractMap);
        request.setAttribute("contractDetailList", contractDetailList);
        try {
            request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        Map<Contract, String> contractMap = contractService.getListWithValue();
        Set<Contract> contractList = contractMap.keySet();
        List<AttachFacility> attachFacilityList = attachFacilityService.getList();
        request.setAttribute("contractList", contractList);
        request.setAttribute("contractMap", contractMap);
        request.setAttribute("attachFacilityList", attachFacilityList);
        try {
            request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);
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
