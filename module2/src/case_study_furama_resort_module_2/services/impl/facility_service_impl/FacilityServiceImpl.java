package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Facility;
import case_study_furama_resort_module_2.services.facility_service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {

    public static Scanner sc = new Scanner(System.in);
    public static Map<Facility, Integer> facilitiesList = new LinkedHashMap<>();


//    private static Facility getInfoFromFile(){
//        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_house_data.csv");
//        FileReader fileReader;
//        BufferedReader bufferedReader;
//
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] str;
//            while ((line = bufferedReader.readLine())!=null){
//                str = line.split(",");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }

    @Override
    public void displayMaintenanceList() {

    }
}
