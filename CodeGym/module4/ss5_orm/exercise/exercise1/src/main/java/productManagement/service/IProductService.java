package productManagement.service;

import productManagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    Product findById(int id);

    void save(Product product);

    void edit(Product product, int id);

    void remove(int id);

    List<Product> search(String search);
}
