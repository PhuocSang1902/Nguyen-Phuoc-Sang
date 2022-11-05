package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> display();

    void add(Product product);

    void edit(int id, Product product);

    void remove(int id);

    void viewDetail(int id, Product product);

    void search(int id, List<Product> productList);

}
