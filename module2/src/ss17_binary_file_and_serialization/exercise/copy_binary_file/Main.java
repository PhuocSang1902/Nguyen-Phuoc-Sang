package ss17_binary_file_and_serialization.exercise.copy_binary_file;

import ss17_binary_file_and_serialization.exercise.product_manager.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        copy();


    }

    public static void copy() {
        List<Product> productList = new ArrayList<>();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            File file = new File
                    ("src\\ss17_binary_file_and_serialization\\exercise\\product_manager\\data\\product_list.dat");

            if (!file.exists()) {
                System.out.println("File is not exist");
            } else {

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
