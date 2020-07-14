package com.leetcode.july;

public class ClockHandAngle {

    public static void main(String[] args){
    System.out.println(angleClock(12, 30));
    }

    public static double angleClock(int hour, int minutes) {

        double hrPos = (360d* (hour+ (minutes/60d)))/12d;
        double minPos = 360d*minutes/60d;

        return Math.abs(minPos - hrPos) > 180? (360 - Math.abs(minPos - hrPos)) : Math.abs(minPos - hrPos);

    }
}
