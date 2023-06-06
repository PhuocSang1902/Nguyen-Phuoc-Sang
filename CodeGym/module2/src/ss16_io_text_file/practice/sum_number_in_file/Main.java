package ss16_io_text_file.practice.sum_number_in_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường link file vào: ");
        String path = scanner.nextLine();
        sumNumbersInFile(path);

    }
    static void sumNumbersInFile(String path){
        try{
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Tổng = " + sum);
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File không tồn tại hoặc dữ liệu bị lỗi.");
        }
    }

}
