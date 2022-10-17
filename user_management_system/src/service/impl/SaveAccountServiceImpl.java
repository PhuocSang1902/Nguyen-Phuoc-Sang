package service.impl;

import model.PaymentAccount;
import model.SaveAccount;
import service.SaveAccountService;
import util.CheckFormat;
import util.FormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveAccountServiceImpl implements SaveAccountService {

    private static Scanner sc = new Scanner(System.in);
    private static List<SaveAccount> saveAccountList = new ArrayList<>();
    private static String path = "src\\data\\bank_accounts.csv";
    private static List<PaymentAccount> paymentAccountList = new ArrayList<>();
    private static PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();

    private SaveAccount inputInfo() {

        int idAccount;
        if (!saveAccountList.isEmpty()) {
            idAccount = saveAccountList.get(saveAccountList.size() - 1).getIdAccount() + 1;
        } else {
            idAccount = 1;
        }

        System.out.print("Hay nhap ma tai khoan(Voi 1 chu S dau tien va 4 so)");
        String codeAccount;
        while (true) {

            codeAccount = sc.nextLine();
            try {
                CheckFormat.checkSaveCode(codeAccount);

                boolean flagCheck = false;
                if (!paymentAccountList.isEmpty()) {
                    for (PaymentAccount account : paymentAccountList) {
                        if (account.getCodeAccount().equals(codeAccount)) {
                            flagCheck = true;
                            break;
                        }
                    }
                }
                if (flagCheck) {
                    System.out.println("Ma tai khoan da ton tai. Hay nhap lai");
                } else {
                    break;
                }

            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String ownerName;
        while (true) {

            System.out.print("Hay nhap ten chu tai khoan: ");
            ownerName = sc.nextLine();
            try {
                CheckFormat.checkName(ownerName);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String creatDate;
        while (true) {
            System.out.print("Hay nhap ngay tao tai khoan (dd-MM-yyyy): ");
            creatDate = sc.nextLine();
            try {
                CheckFormat.checkDate(creatDate);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }


        double moneySave;
        while (true) {

            System.out.print("Hay nhap so tien tiet kiem: ");

            try {
                moneySave = Double.parseDouble(sc.nextLine());
                CheckFormat.checkNumber(moneySave);
                break;
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Hay nhap lai");
            }


        }

        String savaDate;
        while (true) {
            System.out.print("Hay nhap ngay tiet kiem (dd-MM-yyyy): ");
            savaDate = sc.nextLine();
            try {
                CheckFormat.checkDate(savaDate);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        double intervest;
        while (true) {

            System.out.print("Hay nhap lai suat: ");

            try {
                intervest = Double.parseDouble(sc.nextLine());
                CheckFormat.checkNumber(intervest);
                break;
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Hay nhap lai");
            }


        }

        int period;
        while (true) {

            System.out.print("Hay nhap ky han theo thang: ");

            try {
                period = Integer.parseInt(sc.nextLine());
                CheckFormat.checkNumber(period);
                break;
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Hay nhap lai");
            }


        }

        return new SaveAccount(idAccount, codeAccount, ownerName, creatDate, moneySave, savaDate, intervest, period);
    }

    public List<SaveAccount> readFile() {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<SaveAccount> saveAccountList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            SaveAccount saveAccount;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                if (info.length == 8){
                    saveAccount = new SaveAccount();
                    saveAccount.setIdAccount(Integer.parseInt(info[0]));
                    saveAccount.setCodeAccount(info[1]);
                    saveAccount.setOwnerName(info[2]);
                    saveAccount.setCreatDate(info[3]);
                    saveAccount.setSaveMoney(Double.parseDouble(info[4]));
                    saveAccount.setSaveDate(info[5]);
                    saveAccount.setInterest(Double.parseDouble(info[6]));
                    saveAccount.setPeriod(Integer.parseInt(info[7]));

                    saveAccountList.add(saveAccount);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveAccountList;
    }

    public void writeFile(List<SaveAccount> saveAccountList) {
        File file = new File(path);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (SaveAccount saveAccount : saveAccountList) {
                bufferedWriter.write(saveAccount.getInfo());
                bufferedWriter.newLine();
            }
            for (PaymentAccount paymentAccount : paymentAccountList) {
                bufferedWriter.write(paymentAccount.getInfo());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        saveAccountList = readFile();
        paymentAccountList = paymentAccountService.readFile();
        SaveAccount saveAccount = inputInfo();
        saveAccountList.add(saveAccount);
        writeFile(saveAccountList);
    }

    @Override
    public void display() {
        saveAccountList = readFile();
        for (SaveAccount saveAccount : saveAccountList){
            System.out.println(saveAccount.toString());
        }
    }

    @Override
    public void find() {
        saveAccountList = readFile();
        display();

        System.out.println("Hay nhap ma tai khoan ban muon xoa: ");
        String codeAccount = sc.nextLine();
        boolean flagCheck = false;
        for (SaveAccount saveAccount : saveAccountList){
            if (saveAccount.getCodeAccount().equals(codeAccount)){
                System.out.println(saveAccount.toString());
                flagCheck = true;
                break;
            }
        }
        if (!flagCheck){
            System.out.println("Ma tai khoan khong ton tai.");
        }

    }

    @Override
    public void remove() {
        saveAccountList = readFile();
        paymentAccountList = paymentAccountService.readFile();

        System.out.println("Hay nhap ma tai khoan ban muon xoa: ");
        String codeAccount = sc.nextLine();
        boolean flagCheck = false;

        for (int i = 0; i < saveAccountList.size(); i++) {
            if (saveAccountList.get(i).getCodeAccount().equals(codeAccount)) {
                flagCheck = true;
                System.out.println("Ban co chac muon xoa tai khoan nay\n1.Dong y\n2.Khong");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        saveAccountList.remove(saveAccountList.get(i));
                        writeFile(saveAccountList);
                        break;
                    case "2":
                        return;
                    default:
                        System.out.println("Lua chon sai");
                }
            }
        }
        if (!flagCheck) {

            System.out.println("Ma tai khoan khong ton tai");

        }
    }
}
