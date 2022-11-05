package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    static final private List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Hoa Hồng", 8000, "Hoa cánh to nhiều màu", "Đà Lat"));
        productList.add(new Product(2, "Hoa Cúc", 6000, "Hoa cánh nhỏ nhiều cánh", "Đà Nẵng "));
        productList.add(new Product(3, "Hoa Hướng Dương", 10000, "Hoa to nhiều cánh", "Đà Nẵng"));
        productList.add(new Product(4, "Hoa Cẩm Chướng", 11000, "Hoa cách to nhiều cánh nhiều màu", "Da Lat"));
        productList.add(new Product(5, "Hoa Thược Dược", 9000, "Hoa đẹp", "Quy Nhơn"));
        productList.add(new Product(6, "Hoa Đồng Tiền", 7000, "Hoa cánh nhỏ nhiều cánh", "Da Lat"));
        productList.add(new Product(7, "Hoa Ly", 15000, "Hoa cánh to it màu thơm", "Phú Yên"));
    }

    @Override
    public List<Product> display() {

        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){
                index = i;
                break;
            }
        }
        if (index ==  -1){
            add(product);
        }else {
            productList.set(index, product);
        }
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
