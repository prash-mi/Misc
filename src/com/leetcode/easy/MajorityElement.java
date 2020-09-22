package com.leetcode.easy;

import java.util.Arrays;

public class MajorityElement {
    //find the element which occurs more than n/2 times
    public int majorityElement(int[] nums) {
        if (nums==null||nums.length==0){
            return -1;
        }

        Arrays.sort(nums);//now the element will be at n/2 location
        return nums[nums.length/2];
    }
}
