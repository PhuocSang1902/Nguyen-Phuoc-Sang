package ss17_binary_file_and_serialization.practice.copy_big_data_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
//            copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            System.out.printf("Copy completed");
        } catch (IOException e) {
            System.out.printf("Can't copy that file");
            System.out.printf(e.getMessage());
        }
    }

   private static void copyFileUsingJava7Files(File source, File dest) throws IOException{
       Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
   }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\practice\\copy_big_data_files\\demo.csv");
            outputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\practice\\copy_big_data_files\\copy_of_demo.csv");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
