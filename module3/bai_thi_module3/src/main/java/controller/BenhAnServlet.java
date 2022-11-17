package controller;

import model.BenhAn;
import service.IBenhAnService;
import service.impl.BenhAnService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = "/benhAn")
public class BenhAnServlet extends HttpServlet {

    private static final IBenhAnService benhAnService = new BenhAnService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "edit":
                edit(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            default:
                displayList(request, response);
                break;
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.getList();
        request.setAttribute("benhAnList", benhAnList);
        String maBenhAn = request.getParameter("maBenhAn");
        boolean checkRemove = benhAnService.remove(maBenhAn);
        String mess;
        if (checkRemove) {
            mess = "Xóa thành công";
        } else {
            mess = "Xóa không thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.getList();
        request.setAttribute("benhAnList", benhAnList);
        String maBenhAn = request.getParameter("maBenhAn");
        BenhAn benhAn = benhAnService.getById(maBenhAn);
        benhAn.setNgayNhapVien(request.getParameter("ngayNhapVien"));
        benhAn.setNgayRaVien(request.getParameter("ngayRaVien"));
        benhAn.setLyDo(request.getParameter("lyDo"));
        benhAn.setBacSi(request.getParameter("bacSi"));
        benhAn.setPhuongPhap(request.getParameter("phuongPhap"));
        boolean checkEdit = benhAnService.edit(maBenhAn, benhAn);
        String mess;
        if (checkEdit) {
            mess = "Chỉnh sửa thành công";
        } else {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
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
            case "displayAddForm":
                break;
            case "displayEditForm":
                displayEditForm(request, response);
                break;
            default:
                displayList(request, response);
                break;
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        String maBenhAn = request.getParameter("maBenhAn");
        BenhAn benhAn = benhAnService.getById(maBenhAn);
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
        request.setAttribute("benhAn", benhAn);
        request.setAttribute("nowDate", nowDate);
        request.setAttribute("nowDateEndYear", nowDateEndYear);
        try {
            request.getRequestDispatcher("view/edit-form.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.getList();
        request.setAttribute("benhAnList", benhAnList);
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate nowDateEndYear = LocalDate.of(nowYear, 12, 31);
        request.setAttribute("nowDate", nowDate);
        request.setAttribute("nowDateEndYear", nowDateEndYear);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
