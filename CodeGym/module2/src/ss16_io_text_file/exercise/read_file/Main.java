package ss16_io_text_file.exercise.read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class   Main {
    public static void main(String[] args) {
        ArrayList<Country> countriesList = new ArrayList<>();

        File file = new File("src\\ss16_io_text_file\\exercise\\read_file\\countries_list.csv");
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] nationInfo;
            while ((line = bufferedReader.readLine())!=null){
                nationInfo = line.split(",");
                Country country = new Country();
                country.setId(Integer.parseInt(nationInfo[0]));
                country.setCode(nationInfo[1]);
                country.setName(nationInfo[2]);
                countriesList.add(country);
            }
            for (int i = 0; i < countriesList.size(); i++) {
                System.out.println(countriesList.get(i));
            }
        }catch (IOException e){
            System.out.println("file khong ton tai");
        }
    }
}
