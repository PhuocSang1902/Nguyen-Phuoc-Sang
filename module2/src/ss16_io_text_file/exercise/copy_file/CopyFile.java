package ss16_io_text_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        copyFile("src\\ss16_io_text_file\\exercise\\copy_file\\source.csv");
    }

    public static void copyFile(String pathSource) throws IOException {
        try {
            File fileSource = new File(pathSource);
            FileReader fileReader = new FileReader(fileSource);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File fileTarget = new File("src\\ss16_io_text_file\\exercise\\copy_file\\target.csv");
            if (fileTarget.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(fileTarget);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            List<String> list = new ArrayList<>();
            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                Collections.addAll(list, line.split(""));
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            count = list.size();

            System.out.println("So ky tu la: " + count);
            for (String str : list) {
                System.out.print(str);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc file đã có");
        }
    }
}
