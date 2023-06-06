package service;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> display();

    void add(Product product);

    void edit(int id, Product product);

    void remove(int id);

    void viewDetail(int id, Product product);

    List<Product> search(String name);
}
