package com.leetcode.medium;

import java.util.Arrays;

public class MinBalloons {
    public static void main(String[] args){
        int[][] balloons = {{10,16},{2,8},{1,6},{7,12}};
        int[][] balloons2 = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] balloons3 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(new MinBalloons().findMinArrowShots(balloons3));
    }
    //Minimum Number of Arrows to Burst Balloons . O(n log n) time, space O(log n) for Arrays.sort
    public int findMinArrowShots(int[][] balloons) {
        if (balloons == null || balloons.length == 0){
            return 0;
        }
        int arrows = 0;
        Arrays.sort(balloons, (b1, b2) -> Integer.compare(b1[0],b2[0])); //sort the balloons by starting points in asc order
        int runningMinEnd = balloons[0][1];
        for (int[] cur: balloons){//iterate the balloons and see if a balloon starts after any one of the balloons ends (the one which ends would have the min runningMinEnd), if yes then fire an arrow
            if (cur[0]>runningMinEnd){
                arrows++;
                runningMinEnd = cur[1];
            }else {
                runningMinEnd = Math.min(runningMinEnd, cur[1]);
            }

        }
        return arrows+1;//adding 1 because we will need to burst the last balloon, or there could be a case where all the balloons overlapped
    }

}