package com.leetcode.medium;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange2().change(5, coins));
    }
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins==null||coins.length==0){
            return 0;
        }
        int[][] memo = new int[coins.length+1][amount+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return changeCombination(coins, amount, 0,memo);
    }

    //time and space complexity O(amount*coins) . Without memo it would have been exponential
    private int changeCombination(int[] coins, int remainingSum, int ind, int[][] memo) {
        if (remainingSum<0 || ind>=coins.length){
            return 0;
        }

        if (memo[ind][remainingSum]!=-1){
            return memo[ind][remainingSum];
        }
        if (remainingSum==0){//found a combination
            //combinationCnt[0]++;
            return 1;
        }

        int takeCurInd = changeCombination(coins, remainingSum-coins[ind], ind, memo);//IMP: we do not increment ind here, as we should be able to pick the same coin again in the iteration
        int leaveCurInd = changeCombination(coins, remainingSum, ind+1, memo);//we increment ind here, as we are skipping the current coin

        memo[ind][remainingSum] =  takeCurInd+leaveCurInd;

        return memo[ind][remainingSum];
    }
}