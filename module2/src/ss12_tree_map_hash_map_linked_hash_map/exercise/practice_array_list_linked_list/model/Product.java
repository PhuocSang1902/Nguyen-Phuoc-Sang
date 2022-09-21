package ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.model;

public class Product {
    private Integer price;
    private String productName;
    private Integer id;

    public Product() {
    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.productName = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

//    @Override
//    public int compareTo(Product o) {
//        return price - o.price;
//    }
}
