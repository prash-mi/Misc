package com.leetcode.july;

public class ClimbStairs {
    public static void main(String[] args){
      //  System.out.println(new ClimbStairs().climbStairs(5));
        System.out.println(new ClimbStairs().climbStairs(44));
    }

    private int totalWays=0;
    public int climbStairs(int n) {
        if(n<=1){
            return n;
        }

        climbStairsHelper(n,0);
        return totalWays;
    }

    public void climbStairsHelper(int n, int curTotal){
//expensive 2^n solution
        if(n==curTotal){
            totalWays++;
            return ;
        }
        if (curTotal>n){
            return ;
        }
        climbStairsHelper(n, curTotal+1);//take single steps
        climbStairsHelper(n, curTotal+2);//take double steps
    }


    //O(n) time and space
    public int climbStairsDP(int n){
        if (n <= 2){
            return n;
        }

        int[] ways = new int[n];
        ways[0] = 1;//1 way to climb 1
        ways[1] = 2; //1 way to climb 2

        for(int i = 2; i <= n-1; i++){
            ways[i] = ways[i-1]+ways[i-2];
        }

        return ways[n-1];
    }

    //O(n) time and O(1) space
    public int climbStairsDP2(int n){
        if (n <= 2){
            return n;
        }

        int[] ways = new int[3];
        ways[0] = 1;//1 way to climb 1
        ways[1] = 2; //1 way to climb 2

        for(int i = 2; i <= n-1; i++){
            ways[2] = ways[0]+ways[1];
            ways[0] = ways[1];
            ways[1] = ways[2];
        }

        return ways[2];
    }


}
