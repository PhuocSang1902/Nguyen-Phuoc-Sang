package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    static private final IProductService productService = new ProductService();
    private static List<Product> productList = productService.display();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "display":
                display(request, response, productList);
                break;
            case "add":
                add(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product>  findProductList = productService.search(name);
        display(request, response, findProductList);

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        productService.remove(id);
        display(request, response, productList);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");

        Product product = new Product(id, name, price, productDetail, producer);

        productService.edit(id, product);

        display(request, response, productList);
        request.setAttribute("mess", "Successfully add new");

        try {
            request.getRequestDispatcher("product/display.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");

        Product product = new Product(id, name, price, productDetail, producer);
        productService.add(product);
        request.setAttribute("mess", "Successfully add new");
        showAddForm(request, response);

        try {
            request.getRequestDispatcher("product/add.jsp").forward(request, response);
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
                display(request, response, productList);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "viewDetail":
                showDetail(request, response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
            default:
                showHomePage(request, response);
                break;
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/search.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.display();
        Product product = null;
        String str = "";
        for (Product value : productList) {
            if (value.getId() == id) {
                product = value;
                break;
            }
        }

        request.setAttribute("id", product.getId());
        request.setAttribute("name", product.getName());
        request.setAttribute("price", product.getPrice());
        request.setAttribute("productDetail", product.getProductDetail());
        request.setAttribute("producer", product.getProducer());


        try {
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(HttpServletRequest request, HttpServletResponse response, List<Product> productList) {

        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("product/display.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.display();
        Product product = null;
        for (Product value : productList) {
            if (value.getId() == id) {
                product = value;
                break;
            }
        }

        request.setAttribute("id", product.getId());
        request.setAttribute("name", product.getName());
        request.setAttribute("price", product.getPrice());
        request.setAttribute("productDetail", product.getProductDetail());
        request.setAttribute("producer", product.getProducer());


        try {
            request.getRequestDispatcher("product/viewDetail.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
