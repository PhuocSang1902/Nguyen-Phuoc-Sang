package ss17_binary_file_and_serialization.exercise.product_manager.controller;


import ss17_binary_file_and_serialization.exercise.product_manager.service.IProductService;
import ss17_binary_file_and_serialization.exercise.product_manager.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    public static Scanner scanner = new Scanner(System.in);
    public static IProductService productService = new ProductService();

    public static void menu(){
        while(true){
            System.out.println("MANAGEMENT PRODUCT PROGRAM");
            System.out.println("1.Add new product");
            System.out.println("2.Show products list");
            System.out.println("3.Find product");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.show();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.print("Your choice is not correct. Enter again:");
            }
            System.out.println();
        }
    }

    private static void findProduct() {
        System.out.println("Do you want to find product follow code or approximate name");
        System.out.println("1.Follow code");
        System.out.println("2.Follow approximate name");
        System.out.println("3.Return");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                productService.findCode();
                break;
            case 2:
                productService.findApproximateName();
                break;
            case 3:
                return;
        }
    }
}
