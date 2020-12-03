package com.leetcode.medium;

public class CoinChange {

    public static void main(String[] args){
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11 ));
        System.out.println(new CoinChange().coinChange(new int[]{3}, 2 ));
    }

    //Time complexity without memoization would be O(amount^coins) which is exponential, with memo it's O(amount*coins). Space would be O(amount) as the depth of the recursion would be at max equal to the amount given if the min denomination of the coin is 1

    public int coinChange(int[] coins, int amount) {
       int[] memo = new int[amount+1];
       return coinChangeHelper(coins, amount, memo);
    }

    public int coinChangeHelper(int[] coins, int remAmount, int[] memo) {
        if(remAmount == 0){//found a solution, return 0 (1 will be added by the function calling it)
            return 0;
        }

        if (remAmount<0){//no solution is possible
            return -1;
        }

        if (memo[remAmount]!=0){//we have already calculated the solution of this subproblem
            return memo[remAmount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin:coins){//try all the coins at every level
            int curCoins = coinChangeHelper(coins, remAmount-coin, memo);
            if (curCoins!=-1){//that implies we have found a solution in this DFS path
                minCoins = Math.min(curCoins, minCoins);//find min
            }
        }

        memo[remAmount] = (minCoins==Integer.MAX_VALUE? -1: minCoins+1);//if minCoins is Integer.MAX_VALUE, this implies that no solution is found, hence return -1. Otherwise add 1 for every level of recursion, signifying that we have picked a could leading to an over all min number of coins

        return memo[remAmount];
    }

}
