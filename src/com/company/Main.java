package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int r = 0;
        Fan fan = null;

        do {
            Scanner scanner = new Scanner(System.in);
            r = scanner.nextInt();
            fan = new Fan(r);
            fan.printFan();
        }while (r != 0);
    }
}
