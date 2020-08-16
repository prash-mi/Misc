package com.leetcode.easy;

public class BuySellStock2 {
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        if (prices.length <=1){
            return 0;
        }
        int maxProfit = 0;
        int prev = prices[0];
        for (int i = 1; i<prices.length; i++){
            int cur = prices[i];
            if (cur > prev){
                maxProfit += (cur-prev);
            }
            prev = cur;
        }
          return maxProfit;
    }
}
