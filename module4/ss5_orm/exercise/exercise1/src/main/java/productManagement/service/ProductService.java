package productManagement.service;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productManagement.model.Product;
import productManagement.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static List<Product> productList = new ArrayList<>();

    private static ProductRepository productRepository = new ProductRepository();

    static {
        productList.add(new Product(1, "FordTuner", 2000d, "Xe SUV 7 chỗ", "Toyota", true));
        productList.add(new Product(2, "Ford Everest", 4000d, "Xe SUV 5 chỗ", "Ford", true));
        productList.add(new Product(3, "C300", 5000d, "Xe sedan", "Mercedes", true));
        productList.add(new Product(4, "CX-5", 1000d, "Xe SUV 5 chỗ", "Mazda", true));
    }

    public List<Product> getList() {
        return productRepository.getList();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.add(product);
    }

    public void edit(Product product, int id) {
        productRepository.edit(product);
    }

    public void remove(int id) {
        Product product = productRepository.findById(id);
        product.setShow(false);
        productRepository.remove(product);
    }

    public List<Product> search(String search) {

        return productRepository.search(search);
    }
}
