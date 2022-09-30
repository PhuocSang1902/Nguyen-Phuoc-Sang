package ss17_binary_file_and_serialization.exercise.copy_binary_file;

import ss17_binary_file_and_serialization.exercise.product_manager.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("01", "Ford Ranger", "Ford", 15000, "Xe ban tai");
        Product product2 = new Product("02", "Mazda cx5", "Mazda", 12000, "Xe SUV");
        productList.add(product1);
        productList.add(product2);

        writeFile(productList);
        copy();
        productList = readFile();

        for (Product product : productList) {
            System.out.println(product);
        }


    }

    public static List<Product> readFile() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Product> productList = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\exercise\\copy_binary_file\\product_copy.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            productList = (List<Product>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void writeFile(List<Product> productList) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream
                    ("src\\ss17_binary_file_and_serialization\\exercise\\copy_binary_file\\product.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy() {
        List<Product> productList = new ArrayList<>();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            File file = new File
                    ("src\\ss17_binary_file_and_serialization\\exercise\\copy_binary_file\\product.dat");

            if (!file.exists()) {
                System.out.println("File is not exist");
            } else {

                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream
                        ("src\\ss17_binary_file_and_serialization\\exercise\\copy_binary_file\\product_copy.dat");
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
