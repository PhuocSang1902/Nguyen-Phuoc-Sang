package controller;

import model.Facility.Facility;
import model.Facility.FacilityType;
import model.Facility.RentType;
import model.contract.Contract;
import model.contract.ContractDetail;
import model.customer.Customer;
import model.customer.CustomerType;
import repository.IContractRepository;
import service.*;
import service.impl.contract.ContractDetailService;
import service.impl.contract.ContractService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacilittyServlet", urlPatterns = "/facility")
public class FacilittyServlet extends HttpServlet {

    private static IFacilityService facilityService = new FacilityService();
    private static IFacilityTypeService facilityTypeService = new FacilityTypeService();
    private static IRenTypeService renTypeService = new RentTypeService();
    private static IContractDetailService contractDetailService = new ContractDetailService();
    private static IContractService contractService = new ContractService();

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
            case "displayListAttachFacility":
                displayListAttachFacility(request, response);
                break;
        }
    }

    private void displayListAttachFacility(HttpServletRequest request, HttpServletResponse response) {
        String contractId = request.getParameter("contractId");
        List<ContractDetail> contractDetailList = contractDetailService.getListInContract(Integer.parseInt(contractId));
        List<Contract> contractList = contractService.getList();
        request.setAttribute("contractList", contractList);
        request.setAttribute("contractDetailList", contractDetailList);
        try {
            request.getRequestDispatcher("view/customer/list-use-facility.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
//        if (poolArea == null) {
//            poolArea = "0";
//        }
        String numberOfFloor = request.getParameter("numberOfFloor");
//        if (numberOfFloor == null) {
//            numberOfFloor = "0";
//        }
        String facilityFree = request.getParameter("facilityFree");
//        if (facilityFree == null) {
//            facilityFree = "Không có";
//        }
        String facilityTypeName = request.getParameter("facilityTypeName");
        Facility facility = new Facility(name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, numberOfFloor, facilityFree);
        Map<String, String> errorMap = facilityService.add(facility);
        String mess;
        if (errorMap.isEmpty()){
            mess= "Thêm mới thành công";
        }else {
            mess = "Thêm mới không thành công";
            List<FacilityType> facilityTypeList = facilityTypeService.getList();
            List<RentType> rentTypeList = renTypeService.getList();
            String facilityType = facilityTypeName;
            FacilityType facilityTypeInput = new FacilityType(facilityTypeId, facilityTypeName);
            request.setAttribute("facilityTypeList", facilityTypeList);
            request.setAttribute("rentTypeList", rentTypeList);
            request.setAttribute("facilityType", facilityType);
            request.setAttribute("facilityTypeInput", facilityTypeInput);
            LocalDate nowDate = LocalDate.now();
            int nowYear = nowDate.getYear();
            LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
            request.setAttribute("nowDate", nowDate);
            request.setAttribute("nowDateEndYear", nowDateEndYear);
            request.setAttribute("errorMap", errorMap);
            request.setAttribute("facility", facility);
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/facility/add-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.findById(id);
        facility.setName(request.getParameter("name"));
        facility.setArea(request.getParameter("area"));
        facility.setCost(request.getParameter("cost"));
        facility.setMaxPeople(request.getParameter("maxPeople"));
        facility.setRentTypeId(request.getParameter("rentTypeId"));
        facility.setFacilityTypeId(request.getParameter("facilityTypeId"));
        facility.setStandardRoom(request.getParameter("standardRoom"));
        facility.setDescription(request.getParameter("description"));

        if (facility.getFacilityTypeName().equals("House")||facility.getFacilityTypeName().equals("Villa")) {
            facility.setPoolArea(request.getParameter("poolArea"));
        }
        if (facility.getFacilityTypeName().equals("House")||facility.getFacilityTypeName().equals("Villa")) {
            facility.setNumberOfFloor(request.getParameter("numberOfFloor"));
        }
           if (facility.getFacilityTypeName().equals("Room")) {
            facility.setFacilityFree(request.getParameter("facilityFree"));
        }

        boolean checkEdit = facilityService.edit(id, facility);
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
        boolean checkRemove = false;
        if(id != null){
            checkRemove = facilityService.remove(id);
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
        List<Facility> facilityList = facilityService.search(search);
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FacilityType> facilityTypeList = facilityTypeService.getList();
        List<RentType> rentTypeList = renTypeService.getList();
        Facility facility = facilityService.findById(id);
        FacilityType facilityTypeInput = new FacilityType();
        for (FacilityType type : facilityTypeList) {
            if (type.getName().equals(facility.getFacilityTypeName())){
                facilityTypeInput = type;
                break;
            }
        }
        request.setAttribute("facility", facility);
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityTypeInput", facilityTypeInput);
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
        String facilityType = request.getParameter("facilityType");
        FacilityType facilityTypeInput = new FacilityType();
        for (FacilityType type : facilityTypeList) {
            if (type.getName().equals(facilityType)){
                facilityTypeInput = type;
                break;
            }
        }
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityType", facilityType);
        request.setAttribute("facilityTypeInput", facilityTypeInput);
        try {
            request.getRequestDispatcher("view/facility/add-form.jsp").forward(request, response);
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
