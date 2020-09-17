package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class RobotInCircle {

    //Input: "GGLLGG"
    //Output: true

    public static void main(String[] args) {
        System.out.println(new RobotInCircle().isRobotBounded("GGLLGG"));//true
        System.out.println(new RobotInCircle().isRobotBounded("GGLGRG"));//false
        System.out.println(new RobotInCircle().isRobotBounded("LRRRRLLLRL"));//true
        System.out.println(new RobotInCircle().isRobotBounded("LGR"));//false
    }

    //If the the robot doesn't change direction, or if it doesn't return back to the origin in 4 iterations, then it wont form a circle/loop
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || !(instructions.contains("L") || instructions.contains("R"))){//instruction should have atlead a L or a R. it's okay if it isn't having a G
          return false;
        }
        Map<Integer, int[]> moves = new HashMap<>();
        moves.put(0, new int[]{0,1}); moves.put(1, new int[]{-1,0}); moves.put(2, new int[]{0,-1}); moves.put(3, new int[]{1,0});
/*
 Direction 0 North (+y) -> (0,1)
           1 West  (-x) -> (-1,0)
           2 South (-y) -> (0,-1)
           3 East  (+x) -> (+1,0)
 */

        int curDirection = 0;
        int iter = 4;
        int[] curPos = {0,0};
        while (iter>0){
            iter--;
            for (int ind=0; ind<instructions.length();ind++){
                char inst = instructions.charAt(ind);
                if (inst=='G'){//go
                    int[] mov = moves.get(curDirection);
                    curPos[0]+=mov[0];
                    curPos[1]+=mov[1];
                }else if (inst=='L'){//go left
                    curDirection = getDirection(curDirection, 'L');
                }else {
                    curDirection = getDirection(curDirection, 'R');
                }
            }
            if (curPos[0] == 0 && curPos[1] == 0){//robot is back to origin
                return true;
            }
        }
        return false;
    }

    private int getDirection(int curDirection, char move){
        //L rotates anti clockwise
        if (move=='L'){
            curDirection++;
        }else {
            curDirection--;
        }
        return curDirection==4?0:curDirection==-1?3:curDirection;
    }

}
