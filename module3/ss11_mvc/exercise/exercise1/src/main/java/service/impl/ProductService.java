package service.impl;

import controller.ProductServlet;
import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();
    ProductServlet productServlet = new ProductServlet();

    @Override
    public List<Product> display() {
        List<Product> productList = productRepository.display();

        return productList;
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        List<Product> productList = productRepository.display();
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            productRepository.edit(index, product);
        } else {
            productRepository.add(product);
        }
    }

    @Override
    public void remove(int id) {
        List<Product> productList = productRepository.display();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productRepository.remove(i);
                break;
            }
        }
    }

    @Override
    public void viewDetail(int id, Product product) {

    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList= productRepository.display();
        List<Product> findProductList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)){
                findProductList.add(productList.get(i));
            }
        }
        return findProductList;
    }
}
