package controller;

import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilittyServlet")
public class FacilittyServlet extends HttpServlet {

    private static IFacilityService facilityService = new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "display":
                displayList(request, response);
                break;
            case "edit":
                displayList(request, response);
                break;
            case "add":
                displayList(request, response);
                break;
            default:
                displayHomePage(request, response);
                break;
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.getList();
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
