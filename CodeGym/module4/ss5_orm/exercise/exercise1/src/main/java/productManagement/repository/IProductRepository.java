package productManagement.repository;

import productManagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getList();
    void add(Product product);
    void edit(Product product);
    void remove(Product product);
    Product findById(int id);
    List<Product> search(String search);
}
