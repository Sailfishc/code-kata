package com.sailfish.ParkingLot;

/**
 * @author sailfish
 * @create 2019-12-21-7:16 PM
 */
public class ParkingLot {

    private int maxNum = 10;
    private int curNum;

    public ParkingLot() {
        curNum = 0;
    }

    public ParkingLot(int curNum) {
        this.curNum = curNum;
    }

    public boolean park() {
        if (curNum < maxNum) {
            curNum++;
            return true;
        }
        return false;
    }
}
