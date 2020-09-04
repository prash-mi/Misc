package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valToInd = new HashMap<>();
        for (int i  = 0; i < nums.length; i++){
            if (valToInd.containsKey(nums[i]) && i - valToInd.get(nums[i]) <=k ){
                return true;
            }
            valToInd.put(nums[i], i);
        }
    return false;
    }
}
