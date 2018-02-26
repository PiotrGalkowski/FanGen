package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int radian;
        Fan fan = null;

        do {
            Scanner scanner = new Scanner(System.in);
            radian = scanner.nextInt();

            if (radian == 0){
                System.exit(0);
            }


            fan = new Fan();

            fan.setRadian(radian);
            fan.setLeftTurned(radian);
            fan.setFan();

            for(int i = 2; i <= fan.getRadian(); i++){
                fan.setTempRadian(i);
                fan.setTempFirstIndex();
                fan.setTempLastIndex();

                fan.fillTheFan(i);
            }

           fan.printFan();

        }while (true);
    }
}
