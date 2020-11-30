package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSum {
    //Maximum Size Subarray Sum Equals k - Time and space O(n)
/*
Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */
    public static void main(String[] args){
        System.out.println(new MaxSizeSum().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(new MaxSizeSum().maxSubArrayLen(new int[]{-2,-1,2,1}, 1));
    }
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums ==null||nums.length ==0){
            return 0;
        }
        int maxLen = 0;
        int[] prefixSum = new int[nums.length+1];
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0,0);//index 0 of prefixSum has value 0
        for (int i=0; i < nums.length; i++){//compute the prefix sum and populate the prefixSum Array
            prefixSum[i+1] = prefixSum[i] + nums[i];
            if (prefixSumToIndex.containsKey(prefixSum[i+1])){
                int ind =  prefixSumToIndex.get(prefixSum[i+1]);
                prefixSumToIndex.put(prefixSum[i+1], Math.min(i+1, ind));//the min index will be stored so that we can get the max length
            }else {
                prefixSumToIndex.put(prefixSum[i + 1], i + 1);//prefixSum to index in the prefixSum Array
            }
        }

        for (int i=1; i<prefixSum.length; i++){
          //  prefixSum's index i has sum till i-1 of nums
            int rem =  prefixSum[i] - k;
            if (prefixSumToIndex.containsKey(rem)){
                int pInd = prefixSumToIndex.get(rem);
                if (pInd<i){
                    maxLen = Math.max(maxLen, i-pInd);
                }
            }
        }

        return maxLen;
    }

}
