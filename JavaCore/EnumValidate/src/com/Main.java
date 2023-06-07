package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tape login type");
        String typeLogin = sc.nextLine();
        System.out.println(EnumTest.fromString(typeLogin).toString());

    }
}
