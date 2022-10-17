package controller;

import service.PaymentAccountService;
import service.SaveAccountService;
import service.impl.PaymentAccountServiceImpl;
import service.impl.SaveAccountServiceImpl;

import java.util.Scanner;

public class AccountController {

    private static Scanner sc = new Scanner(System.in);
    private static PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private static SaveAccountService saveAccountService = new SaveAccountServiceImpl();

    public static void displayProgram() {
        while (true){
            System.out.println("---CHUONG TRINH QUAN LY TAI KHOAN NGAN HANG---");
            System.out.println("Chon chuc nang theo so de tiep tuc: ");
            System.out.println("1.Them moi");
            System.out.println("2.Xoa");
            System.out.println("3.Xem danh sach cac tai khoan ngan hang");
            System.out.println("4.Tim kiem");
            System.out.println("5.Thoat");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    add();
                    break;
                case "2":
                    remove();
                    break;
                case "3":
                    saveAccountService.display();
                    paymentAccountService.display();
                    break;
                case "4":
                    find();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Lua chon sai. Hay chon lai: ");
            }
        }
    }

    private static void find() {
        while (true){
            System.out.println("---Tim kiem tai khoan---");
            System.out.println("Chon chuc nang theo so de tiep tuc: ");
            System.out.println("1.Tim kiem tai khoan tiet kiem");
            System.out.println("2.Tim kiem tai khoan thanh toan");
            System.out.println("3.Tro lai");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    saveAccountService.find();
                    break;
                case "2":
                    paymentAccountService.find();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Lua chon sai. Hay chon lai: ");
            }
        }
    }

    private static void remove() {
        while (true){
            System.out.println("---Xoa tai khoan---");
            System.out.println("Chon chuc nang theo so de tiep tuc: ");
            System.out.println("1.Xoa tai khoan tiet kiem");
            System.out.println("2.Xoa tai khoan thanh toan");
            System.out.println("3.Tro lai");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    saveAccountService.remove();
                    break;
                case "2":
                    paymentAccountService.remove();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Lua chon sai. Hay chon lai: ");
            }
        }
    }

    public static void add(){
        while (true){
            System.out.println("---Them moi tai khoan---");
            System.out.println("Chon chuc nang theo so de tiep tuc: ");
            System.out.println("1.Them moi tai khoan tiet kiem");
            System.out.println("2.Them moi tai khoan thanh toan");
            System.out.println("3.Tro lai");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    saveAccountService.add();
                    break;
                case "2":
                    paymentAccountService.add();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Lua chon sai. Hay chon lai: ");
            }
        }
    }
}
