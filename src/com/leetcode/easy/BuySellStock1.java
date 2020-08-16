package com.leetcode.easy;

import java.util.Map;

public class BuySellStock1 {
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        if (prices.length <=1){
            return 0;
        }

        int maxProfit = 0;
        int curMin = prices[0];
        for (int prc:prices){
            curMin = Math.min(curMin, prc);
            maxProfit = Math.max(maxProfit, (prc-curMin));
        }
        return maxProfit;
    }
}
