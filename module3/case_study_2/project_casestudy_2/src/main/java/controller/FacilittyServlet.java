package controller;

import model.Facility.Facility;
import model.Facility.FacilityType;
import model.Facility.RentType;
import model.customer.Customer;
import model.customer.CustomerType;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRenTypeService;
import service.impl.facility.FacilityService;
import service.impl.facility.FacilityTypeService;
import service.impl.facility.RentTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "FacilittyServlet", urlPatterns = "/facility")
public class FacilittyServlet extends HttpServlet {

    private static IFacilityService facilityService = new FacilityService();
    private static IFacilityTypeService facilityTypeService = new FacilityTypeService();
    private static IRenTypeService renTypeService = new RentTypeService();

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
        String area = request.getParameter("area");
        String cost = request.getParameter("cost");
        String maxPeople = request.getParameter("maxPeople");
        String rentTypeId = request.getParameter("rentTypeId");
        String facilityTypeId = request.getParameter("facilityTypeId");
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        String poolArea = request.getParameter("poolArea");
        String numberOfFloor = request.getParameter("numberOfFloor");
        String facilityFree = request.getParameter("facilityFree");
        Facility facility = new Facility(name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, numberOfFloor, facilityFree);
        boolean checkAdd = facilityService.add(facility);
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
        List<FacilityType> facilityTypeList = facilityTypeService.getList();
        List<RentType> rentTypeList = renTypeService.getList();
        Facility facility = facilityService.findById(id);
        facility.setName(request.getParameter("name"));
        facility.setArea(request.getParameter("customerType"));
        facility.setCost(request.getParameter("birthday"));
        facility.setMaxPeople(request.getParameter("gender"));
        facility.setRentTypeId(request.getParameter("idCard"));
        facility.setFacilityTypeId(request.getParameter("phoneNumber"));
        facility.setStandardRoom(request.getParameter("email"));
        facility.setDescription(request.getParameter("address"));
        facility.setPoolArea(request.getParameter("address"));
        facility.setNumberOfFloor(request.getParameter("address"));
        String numberOfFloor = request.getParameter("address");
        if (numberOfFloor != null) {
            facility.setNumberOfFloor(numberOfFloor);
        }else {
            numberOfFloor = "Không áp dụng";
            facility.setNumberOfFloor(numberOfFloor);
        }
        String facilityFree = request.getParameter("address");
        if (facilityFree != null) {
            facility.setFacilityFree(facilityFree);
        }else {
            facilityFree = "Không áp dụng";
            facility.setFacilityFree(facilityFree);
        }
        boolean checkEdit = customerService.edit(id, facility);
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
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FacilityType> facilityTypeList = facilityTypeService.getList();
        List<RentType> rentTypeList = renTypeService.getList();
        Facility facility = facilityService.findById(id);
        request.setAttribute("facility", facility);
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("rentTypeList", rentTypeList);

        try {
            request.getRequestDispatcher("view/facility/edit-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<FacilityType> facilityTypeList = facilityTypeService.getList();
        List<RentType> rentTypeList = renTypeService.getList();
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            request.getRequestDispatcher("view/customer/").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.getList();
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayHomePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
