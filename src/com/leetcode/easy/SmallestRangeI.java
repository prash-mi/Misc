package com.leetcode.easy;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {

        if (nums == null|| nums.length <=1){
            return 0;
        }

        //get the max and the min values in the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n: nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        //we just need to consider the min and the max elements and see how close can they come. We can ignore a scenario where the min is no longer min since we added k

        return Math.max(0 , ((max-k) - (min+k)));//the difference should not go beyond 0

    }
}
