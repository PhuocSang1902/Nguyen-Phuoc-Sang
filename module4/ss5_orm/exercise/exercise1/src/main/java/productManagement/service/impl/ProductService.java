package productManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productManagement.model.Product;
import productManagement.repository.impl.ProductRepository;
import productManagement.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.add(product);
    }

    @Override
    public void edit(Product product, int id) {
        productRepository.edit(product);
    }

    @Override
    public void remove(int id) {
        Product product = productRepository.findById(id);
        product.setShow(false);
        productRepository.remove(product);
    }

    @Override
    public List<Product> search(String search) {

        return productRepository.search(search);
    }
}
