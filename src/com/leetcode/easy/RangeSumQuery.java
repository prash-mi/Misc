package com.leetcode.easy;

// Range Sum Query - Immutable

public class RangeSumQuery {
    int[] sum ;
    public RangeSumQuery(int[] nums) {//(n) preprocessing time
        sum = new int[nums.length+1];
        for (int i =0; i < nums.length; i++){
            sum[i+1] = sum[i]+nums[i];//sum till ith index will be at i+1th index of sum[]
        }
    }

    public int sumRange(int i, int j) {//O(1)
        //get the sum till jth index (sum[j+1]) and substract sum till i-1 th index (sum[i])
        return sum[j+1] - sum[i];
    }
}
