package ss17_binary_file_and_serialization.exercise.product_manager.service;

import ss17_binary_file_and_serialization.exercise.product_manager.model.Product;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    void add();

    void findCode();

    void findApproximateName();

    void show();

    void writeFile(List<Product> productList);

}
