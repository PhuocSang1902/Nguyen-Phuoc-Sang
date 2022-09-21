package ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.service.impl;

import ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.model.Product;
import ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.service.IProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Product> productArrayList = new ArrayList<>();

    public Product infoProduct() {
        System.out.print("Enter id of product: ");
        Integer id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name of product: ");
        String name = sc.nextLine();
        System.out.print("Enter price of product: ");
        Integer price = Integer.parseInt(sc.nextLine());
        return new Product(id, name, price);
    }

    public void add() {
        Product product = infoProduct();
        productArrayList.add(product);
    }

    public void edit() {
        System.out.print("Enter ID of product that you want to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
                System.out.print("You want to edit name or price or both? 1.name, 2 price, 3.both");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter name of product you want to edit: ");
                        String name = sc.nextLine();
                        product.setProductName(name);
                        System.out.println("Edit successfully");
                        break;
                    case 2:
                        System.out.print("Enter price of product you want to edit: ");
                        Integer price = Integer.parseInt(sc.nextLine());
                        product.setPrice(price);
                        System.out.println("Edit successfully");
                        break;
                    case 3:
                        System.out.print("Enter name of product you want to edit: ");
                        name = sc.nextLine();
                        System.out.print("Enter price of product you want to edit: ");
                        price = Integer.parseInt(sc.nextLine());
                        product.setProductName(name);
                        product.setPrice(price);
                        System.out.println("Edit successfully");
                        break;
                }
            }
        }
    }

    public void remove() {
        boolean flagRemove = false;
        System.out.print("Enter id of product you want to remove: ");
        Integer id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId().equals(id)) {
                productArrayList.remove(i);
                System.out.println("Remove successfully.");
                flagRemove = true;
                break;
            }
        }
        if (!flagRemove) {
            System.out.println("The id of product is not exist.");
        }
    }

    public void display() {
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
    }

    public void sort() {
        productArrayList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
    }
}
