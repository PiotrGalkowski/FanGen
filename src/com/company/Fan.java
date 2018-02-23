package com.company;

public class Fan {

    private int r;
    private int rMinus;
    private char[][] fan;
    private int lastIndex;

    public Fan(int r) {
        if (r > 0){
            this.r = r;
            this.fan = new char[2*this.r][2*this.r];
            this.lastIndex = (2*this.r)-1;
        }else {
            this.rMinus = r;
            this.r = r*(-1);
            this.fan = new char[(2*r)*(-1)][(2*r)*(-1)];
            this.lastIndex = ((2*r)*(-1))-1;
        }
    }

    public Fan(){

    }

    public void printFan() {

        if (r == 0){
            System.exit(0);
        }

        fillCenter();

        if (r > 1 || rMinus < -1){
            fillCorners();

            fillAround();

            for (int i = 0; i < lastIndex+1; i++){
                for (int j = 0; j < lastIndex+1; j++){
                    System.out.print(fan[i][j]);
                }
                System.out.println();
            }
        }
    }

    private void fillCorners() {
        fan[0][0] = '*';
        fan[0][lastIndex] = '*';
        fan[lastIndex][0] = '*';
        fan[lastIndex][lastIndex] = '*';
    }

    private void fillCenter(){
        fan[r-1][r-1] = '*';
        fan[r-1][r] = '*';
        fan[r][r-1] = '*';
        fan[r][r] = '*';
    }

    private void fillAround(){
        if (r > 0 && rMinus == 0){
            fanLeftTurned();
        }else {
            fanRightTurned();
        }
    }

    private void fanRightTurned() {
        for (int i = 0; i < 2 * r; i++) {
            for (int j = 0; j < 2 * r; j++) {
                if (!(fan[i][j] == '*')) {
                    if (i == 0 && j < r || i < r && j == lastIndex ||
                            i == lastIndex && j >= r || i >= r && j == 0) {
                        fan[i][j] = '.';
                    } else {
                        fan[i][j] = '*';
                    }
                }
            }
        }
    }


    private void fanLeftTurned() {
        for (int i = 0; i < 2*r; i++){
            for (int j = 0; j < 2*r; j++){
                if (!(fan[i][j] == '*')){
                    if (i == 0 && j >= r || i >= r && j == lastIndex ||
                            i == lastIndex && j < r || i < r && j == 0) {
                        fan[i][j] = '.';
                    } else {
                        fan[i][j] = '*';
                    }
                }
            }
        }
    }


    public void setR(int r) {
        if (r > 0) {
            this.r = r;
        }else {
            this.rMinus = r;
            this.r = r*(-1);
        }
    }

    public void setrMinus(int r) {
        if(r < 0) {
            this.rMinus = r;
        }
    }

    public void setFan(int r) {
        if (r > 0) {
            this.fan = new char[2*this.r][2*this.r];
        }else{
            this.fan = new char[(2*r)*(-1)][(2*r)*(-1)];
        }
    }

    public void setLastIndex(int r) {
        if(r > 0) {
            this.lastIndex = (2*this.r)-1;
        }else {
            this.lastIndex = ((2*r)*(-1))-1;
        }
    }
}
