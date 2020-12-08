package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    public static void main(String[] args){
        System.out.println(new FrogJump().canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(new FrogJump().canCross(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println(new FrogJump().canCross(new int[]{0,2}));
    }

    Map<Integer, Integer> posToInd = new HashMap<>();

    //Time and space O(n^2) [as the jump size is increasing max by 1, so for a stone length of 5, it will max be 5, and then we can atmost explore 5 times 5 combinations - given we are using memoisation and posToInd map] space O(n^2). Without memoization the time complexity would be O(3^n) [3 choices at each of n places] ; where n=stones.length
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length==0){
            return false;
        }

        for (int i=0; i<stones.length; i++){
            posToInd.put(stones[i], i);
        }
        int[][] memo = new int[stones.length][stones.length];
        return canCrossHelper(stones, 0, 1, memo);//starting with the 0th index and jumpSize=1
    }

    private boolean canCrossHelper(int[] stones, int curStoneIndex, int jumpSize, int[][] memo){
        if (curStoneIndex == stones.length-1){//reached the last index, problem solved
            return true;
        }
        if (jumpSize<=0 || curStoneIndex >= stones.length){//invalid index or jumpSize
            return false;
        }

        if (memo[curStoneIndex][jumpSize] == -1){//this sub-problem has be solved and we didn't find a solution
            return false;
        }

        //now we can do jumpSize = jumpSize-1, jumpSize or jumpSize+1. First Jump will ne just 1
        int jumpSizeVariance = 1;
        if (curStoneIndex == 0){//first jump - special case, for the remaining jumps we wil do jumpSize = jumpSize-1, jumpSize or jumpSize+1
            jumpSizeVariance = 0;
        }
        for(int newJumpSize = jumpSize-jumpSizeVariance; newJumpSize<=jumpSize+jumpSizeVariance; newJumpSize++){
            int nextStoneIndex = getNextStoneIndex(stones, curStoneIndex, newJumpSize);
            if (nextStoneIndex>curStoneIndex && canCrossHelper(stones, nextStoneIndex, newJumpSize, memo)){//we should move towards the right, as going back isn't allowed. If reached till the last index then the problem is solved.
                return true;
            }
        }
        memo[curStoneIndex][jumpSize] = -1;//we could not reach the end from the curStoneIndex with the given jumpSizes, so storing the result in order to optimise the repeating subproblems
        return false;//problem could not be solved
    }

    private int getNextStoneIndex(int[] stones, int curStoneIndex, int newJumpSize) {
        int newStonePos = stones[curStoneIndex] + newJumpSize;
        return posToInd.getOrDefault(newStonePos, -1);
    }
}