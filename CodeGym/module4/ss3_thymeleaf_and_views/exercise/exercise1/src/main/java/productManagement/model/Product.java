package productManagement.model;

public class Product {
    private int id;
    private String name;
    private Double cost;
    private String describe;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, Double cost, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.describe = describe;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
