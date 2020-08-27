package com.leetcode.aug;



public class BuySellStock3 {
    public static void main(String[] args){
        int[] ip1 = {3,3,5,0,0,3,1,4};
        int[] ip2 = {1,2,3,4,5};
        int[] ip3 = {7,6,4,3,1};
        System.out.println(new BuySellStock3().maxProfit(ip1));
        System.out.println(new BuySellStock3().maxProfit(ip2));
        System.out.println(new BuySellStock3().maxProfit(ip3));
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<=1){
            return 0;
        }

        int maxProfit = Integer.MIN_VALUE;
        int[] auxLeft = new int[prices.length+1], auxRight = new int[prices.length+1];
        int minLeft = prices[0];
        int maxRight = prices[prices.length-1];

        for (int lft = 0; lft<prices.length; lft++){

            minLeft = Math.min(minLeft, prices[lft]);
            auxLeft[lft+1] = Math.max(auxLeft[lft], (prices[lft] - minLeft));//there is an additional place in auxLeft @ index 0

            int rgt = prices.length-1-lft;
            maxRight = Math.max(maxRight, prices[rgt]);
            auxRight[rgt] = Math.max(auxRight[rgt+1], (maxRight-prices[rgt]));//there is an additional place in auxLeft @ the last index
        }

        for (int lft = 0; lft<prices.length; lft++){
            maxProfit = Math.max(maxProfit, (auxLeft[lft+1]+ auxRight[lft]));//auxLeft[lft+1] because index 0 of the leftAux was an extra space
        }

        return maxProfit;
    }
}
