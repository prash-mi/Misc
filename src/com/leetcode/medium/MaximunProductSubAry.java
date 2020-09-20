package com.leetcode.medium;

public class MaximunProductSubAry {
    public static void main(String[] args) {
        int[] ary = {-4,-3,-2};
        System.out.println(new MaximunProductSubAry().maxProduct(ary)) ;
    }
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int minSoFar=nums[0], maxSoFar=nums[0], maxProduct = nums[0];
        int maxSoFarTemp;
        for (int i=1;i<nums.length; i++){
            int cur = nums[i];
            if (cur==0){
                maxSoFar=0;
                minSoFar=0;
            }
            maxSoFarTemp = Math.max(cur, Math.max(cur*maxSoFar, cur*minSoFar));//keeping the maxSoFar in a temp variable as otherwise the modified value will be used in the next line
            minSoFar = Math.min(cur, Math.min(cur*maxSoFar, cur*minSoFar));
            maxSoFar = maxSoFarTemp;
            maxProduct = Math.max(maxProduct, maxSoFar);
        }
    return maxProduct;
    }
}
