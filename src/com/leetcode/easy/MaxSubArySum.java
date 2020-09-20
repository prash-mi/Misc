package com.leetcode.easy;

public class MaxSubArySum {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int runningMax = nums[0], maxSum = nums[0];
        for (int i=1; i<nums.length; i++){
            runningMax = Math.max(runningMax+nums[i], nums[i]);
            maxSum = Math.max(runningMax, maxSum);
        }
        return maxSum;
    }
}
