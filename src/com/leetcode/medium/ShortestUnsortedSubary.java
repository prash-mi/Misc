package com.leetcode.medium;

import java.util.Arrays;

public class ShortestUnsortedSubary {
    public int findUnsortedSubarray(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        //now find the index where the mismatch started to happen
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int i =0; i < nums.length; i++){
            if (nums[i] != sorted[i]){
                start = Math.min(start, i);//first mismatch is start
                end = Math.max(end, i);//last mismatch is end of the unsorted array
            }
        }

        //length will be end-start+1 , or 0 if the sequence was sorted
        return (start==Integer.MAX_VALUE || end == Integer.MIN_VALUE)?0: (end-start+1);
    }
}
