package service.impl;

import model.PaymentAccount;
import model.SaveAccount;
import service.PaymentAccountService;
import service.SaveAccountService;
import util.CheckFormat;
import util.FormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static Scanner sc = new Scanner(System.in);
    private static List<PaymentAccount> paymentAccountList = new ArrayList<>();
    private static List<SaveAccount> saveAccountList = new ArrayList<>();
    private static SaveAccountServiceImpl saveAccountService = new SaveAccountServiceImpl();
    private static String path = "src\\data\\bank_accounts.csv";

    private PaymentAccount inputInfo() {

        int idAccount;
        if (!paymentAccountList.isEmpty()) {
            idAccount = paymentAccountList.get(paymentAccountList.size() - 1).getIdAccount() + 1;
        } else {
            idAccount = 1;
        }

        System.out.print("Hay nhap ma tai khoan (Voi 1 chu P dau tien va 4 so)");
        String codeAccount;
        while (true) {

            codeAccount = sc.nextLine();
            try {
                CheckFormat.checkPaymentCode(codeAccount);

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

        String cardNumber;
        while (true) {
            System.out.print("Hay nhap so the: ");
            cardNumber = sc.nextLine();

            try {
                CheckFormat.checkNumber(Double.parseDouble(cardNumber));
                break;
            } catch (FormatException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }



        }

        double moneyAccount;
        while (true) {

            System.out.print("Hay nhap so tien trong tai khoan: ");

            try {
                moneyAccount = Double.parseDouble(sc.nextLine());
                CheckFormat.checkNumber(moneyAccount);
                break;
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Hay nhap lai");
            }


        }

        return new PaymentAccount(idAccount, codeAccount, ownerName, creatDate, cardNumber, moneyAccount);
    }

    public List<PaymentAccount> readFile() {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<PaymentAccount> paymentAccountList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            PaymentAccount paymentAccount;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                if (info.length == 6){
                    paymentAccount = new PaymentAccount();
                    paymentAccount.setIdAccount(Integer.parseInt(info[0]));
                    paymentAccount.setCodeAccount(info[1]);
                    paymentAccount.setOwnerName(info[2]);
                    paymentAccount.setCreatDate(info[3]);
                    paymentAccount.setCardNumber(info[4]);
                    paymentAccount.setMoneyAccount(Double.parseDouble(info[5]));

                    paymentAccountList.add(paymentAccount);
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
        return paymentAccountList;
    }

    public void writeFile(List<PaymentAccount> paymentAccountList) {
        File file = new File(path);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (PaymentAccount paymentAccount : paymentAccountList) {
                bufferedWriter.write(paymentAccount.getInfo());
                bufferedWriter.newLine();
            }
            for(SaveAccount saveAccount : saveAccountList){
                bufferedWriter.write(saveAccount.getInfo());
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
        paymentAccountList = readFile();
        saveAccountList = saveAccountService.readFile();
        PaymentAccount paymentAccount = inputInfo();
        paymentAccountList.add(paymentAccount);
        writeFile(paymentAccountList);
    }

    @Override
    public void display() {
        paymentAccountList = readFile();
        for (PaymentAccount paymentAccount : paymentAccountList){
            System.out.println(paymentAccount.toString());
        }

    }

    @Override
    public void find() {
        paymentAccountList = readFile();
        display();

        System.out.println("Hay nhap ma tai khoan ban muon xoa: ");
        String codeAccount = sc.nextLine();
        boolean flagCheck = false;
        for (PaymentAccount paymentAccount : paymentAccountList){
            if (paymentAccount.getCodeAccount().equals(codeAccount)){
                System.out.println(paymentAccount.toString());
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
        paymentAccountList = readFile();
        saveAccountList = saveAccountService.readFile();

        System.out.println("Hay nhap ma tai khoan ban muon xoa: ");
        String codeAccount = sc.nextLine();
        boolean flagCheck = false;

        for (int i = 0; i < paymentAccountList.size(); i++) {
            if (paymentAccountList.get(i).getCodeAccount().equals(codeAccount)) {
                flagCheck = true;
                System.out.println("Ban co chac muon xoa tai khoan nay\n1.Dong y\n2.Khong");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        paymentAccountList.remove(paymentAccountList.get(i));
                        writeFile(paymentAccountList);
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
