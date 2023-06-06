package ss16_io_text_file.practice.find_max_value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try{
            File file = new File("src\\ss16_io_text_file\\practice\\find_max_value\\numbers.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int max;
            List<Integer> listNumbersInFile = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                listNumbersInFile.add(Integer.parseInt(line));
            }
            max = listNumbersInFile.get(0);
            for(Integer number: listNumbersInFile){
                if (number > max){
                    max = number;
                }
            }
            System.out.println("Max is " + max);
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File is not exist or data is not correct format.");
        }
    }
}
