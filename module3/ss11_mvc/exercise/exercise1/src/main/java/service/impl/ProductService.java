package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

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
        productRepository.edit(product.getId(), product);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void viewDetail(int id, Product product) {

    }

    @Override
    public void search(int id, List<Product> productList) {

    }
}
