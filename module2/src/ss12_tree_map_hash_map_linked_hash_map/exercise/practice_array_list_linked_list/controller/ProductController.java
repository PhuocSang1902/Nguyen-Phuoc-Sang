package ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.controller;

import ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.model.Product;
import ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.service.IProductService;
import ss12_tree_map_hash_map_linked_hash_map.exercise.practice_array_list_linked_list.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    public static Scanner sc = new Scanner(System.in);
    public static IProductService productService = new ProductService();

    public static void menu() {
        Product product1 = new Product(1, "iphong 14 pro max", 30000);
        Product product2 = new Product(2, "iphong 14 pro", 25000);
        Product product3 = new Product(3, "iphong 14", 15000);
        Product product4 = new Product(4, "iphong 14 plus", 20000);
        Product product5 = new Product(5, "iphong 13", 10000);
        ProductService.productArrayList.add(product1);
        ProductService.productArrayList.add(product2);
        ProductService.productArrayList.add(product3);
        ProductService.productArrayList.add(product4);
        ProductService.productArrayList.add(product5);
        while (true) {
            System.out.println("PRODUCT MANAGEMENT PROGRAM");
            System.out.println("1.Add product");
            System.out.println("2.Edit product information follow id");
            System.out.println("3.Remove product follow id");
            System.out.println("4.Display all product follow id");
            System.out.println("5.Short product follow price");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.edit();
                    break;
                case 3:
                    productService.remove();
                    break;
                case 4:
                    productService.display();
                    break;
                case 5:
                    productService.sort();
                    break;
                case 6:
                    System.exit(0);

            }
        }
    }






}
