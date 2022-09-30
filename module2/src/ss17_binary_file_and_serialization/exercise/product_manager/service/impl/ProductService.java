package ss17_binary_file_and_serialization.exercise.product_manager.service.impl;


import ss17_binary_file_and_serialization.exercise.product_manager.model.Product;
import ss17_binary_file_and_serialization.exercise.product_manager.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {

    public static Scanner scanner = new Scanner(System.in);
    List<Product> productsList = new ArrayList<>();

    @Override
    public void add() {
        if (getDataFromFile() != null) {
            productsList = getDataFromFile();
        }
        Product product = inputInfo();
        productsList.add(product);
        System.out.println("Successfully added new");
        System.out.println();
        writeFile(productsList);
    }

    @Override
    public void findCode() {
        if (getDataFromFile() != null) {
            productsList = getDataFromFile();
        }
        System.out.print("Enter the code of product you want to find:");
        String code = scanner.nextLine();
        boolean flagFind = false;
        for (Product product : productsList) {
            if (product.getCode().equals(code)) {
                System.out.println(product.toString());
                flagFind = true;
                break;
            }
        }
        if (!flagFind) {
            System.out.println("There is not product have code exist.");
        }
    }

    @Override
    public void findApproximateName() {
        if (getDataFromFile() != null) {
            productsList = getDataFromFile();
        }
        List<Product> products = new ArrayList<>();
        System.out.print("Enter the word of product name you want to find:");
        String name = scanner.nextLine();
        for (Product product : productsList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        if (products.size() != 0) {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("There is not product have code exist.");
        }
    }

    @Override
    public void show() {
        if (getDataFromFile() != null) {
            productsList = getDataFromFile();
        }
        for (Product product : productsList) {
            System.out.println(product);
        }
    }

    public Product inputInfo() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        System.out.print("Enter name of product: ");
        String name = scanner.nextLine();
        System.out.print("Enter producer:");
        String producer = scanner.nextLine();
        System.out.print("Enter price:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter other description:");
        String description = scanner.nextLine();

        Product product = new Product(code, name, producer, price, description);
        return product;
    }

    public List<Product> getDataFromFile() {
        List<Product> productList = new ArrayList<>();
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fileInputStream = new FileInputStream
                    ("src\\ss17_binary_file_and_serialization\\exercise\\product_manager\\data\\product_list.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            productList = (List<Product>) objectInputStream.readObject();

        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }

        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void writeFile(List<Product> productList) {

        ObjectOutputStream objectOutputStream = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream
                    ("src\\ss17_binary_file_and_serialization\\exercise\\product_manager\\data\\product_list.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void copy(){
        List<Product> productList = new ArrayList<>();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            File file = new File("src\\ss17_binary_file_and_serialization\\exercise\\product_manager\\data\\product_list.dat");

            if(!file.exists()){
                System.out.println("File is not exist");
            }else {

                FileInputStream fileInputStream = new FileInputStream
                        (file);
                FileOutputStream fileOutputStream = new FileOutputStream
                        ("src\\ss17_binary_file_and_serialization\\exercise\\product_manager\\data\\product_list_coppy.dat");
                objectInputStream = new ObjectInputStream(fileInputStream);
                long size = fileInputStream.getChannel().size();
                System.out.println("The file size is " + size + " bytes");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                productList = (List<Product>) objectInputStream.readObject();
                objectOutputStream.writeObject(productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File is empty or file is not exist");
        }
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
