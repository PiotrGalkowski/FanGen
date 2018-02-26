package com.company;

public class Fan {

    private int radian;
    private boolean isLeftTurned;
    private char[][] fan;

    private int tempRadian;
    private int tempLastIndex;
    private int tempFirstIndex;



    public void printFan() {
        for (int i = 0; i < (radian*2); i++) {
            for (int j = 0; j < (radian*2); j++) {
                System.out.print(fan[i][j]);
            }
            System.out.println();
        }
    }

    public void fillTheFan(int tempRadian){
        if (tempRadian <= 2){
            fillCenter();
        }

        fillCorners();

        fillTheRest();
    }

    private void fillTheRest(){
        if (isLeftTurned){
            fillFanLeftTurned();
        }else {
            fanFanRightTurned();
        }
    }

    private void fillCorners() {
        fan[tempFirstIndex][tempFirstIndex] = '*';
        fan[tempFirstIndex][tempLastIndex] = '*';
        fan[tempLastIndex][tempFirstIndex] = '*';
        fan[tempLastIndex][tempLastIndex] = '*';
    }

    private void fillCenter(){
        fan[radian-1][radian-1] = '*';
        fan[radian-1][radian] = '*';
        fan[radian][radian-1] = '*';
        fan[radian][radian] = '*';
    }

    private void fillFanLeftTurned() {
        for (int i = tempFirstIndex; i <= tempLastIndex; i++){
            for (int j = tempFirstIndex; j <= tempLastIndex; j++){
                if (!(fan[i][j] == '*') && !(fan[i][j] == '.')){
                    if (i == tempFirstIndex && j >= radian
                            || i >= radian && j == tempLastIndex
                            || i == tempLastIndex && j < radian
                            || i < radian && j == tempFirstIndex) {
                        fan[i][j] = '.';
                    } else {
                        fan[i][j] = '*';
                    }
                }
            }
        }
    }

    private void fanFanRightTurned() {
        for (int i = tempFirstIndex; i <=tempLastIndex; i++) {
            for (int j = tempFirstIndex; j <= tempLastIndex; j++) {
                if (!(fan[i][j] == '*') && !(fan[i][j] == '.')) {
                    if (i == tempFirstIndex && j < radian
                            || i < radian && j == tempLastIndex
                            || i == tempLastIndex && j >= radian
                            || i >= radian && j == tempFirstIndex) {
                        fan[i][j] = '.';
                    } else {
                        fan[i][j] = '*';
                    }
                }
            }
        }
    }

    public void setRadian(int radian) {
        if (radian > 0) {
            this.radian = radian;
        }else {
            this.radian = radian*(-1);
        }
    }

    public int getRadian() {
        return radian;
    }

    public void setLeftTurned(int radian) {
        if (radian > 0){
            this.isLeftTurned = true;
        }else {
            this.isLeftTurned = false;
        }
    }

    public void setFan() {
        this.fan = new char[2 * radian][2 * radian];
    }

    public void setTempRadian(int radian){
        this.tempRadian = radian;
    }

    public void setTempLastIndex() {
        this.tempLastIndex = radian + tempRadian -1;
    }

    public void setTempFirstIndex() {
        this.tempFirstIndex = radian - tempRadian;
    }
}
