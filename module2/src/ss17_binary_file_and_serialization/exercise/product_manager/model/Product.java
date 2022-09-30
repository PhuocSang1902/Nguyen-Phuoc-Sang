package ss17_binary_file_and_serialization.exercise.product_manager.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private String producer;
    private int price;
    private String otherDescription;

    public Product() {
    }

    public Product(String code, String name, String producer, int price, String otherDescription) {
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }
}
