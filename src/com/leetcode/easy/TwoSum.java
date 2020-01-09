package com.leetcode.easy;
//https://leetcode.com/problems/two-sum/
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args){
        int[] ip =  {2, 7, 11, 15};
        int[] result = getIndices(ip, 13);
        System.out.println(result[0]+" "+result[1]);
    }

    static int[] getIndices(int[] nums, int target){
        int[] op = {-1, -1};

        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            numbers.put(nums[i], i);
        }

        for (int i = 0; i<nums.length; i++){
            int second = target - nums[i];

            if(numbers.containsKey(second)){
                int secondInd = numbers.get(second);
                if (secondInd == i){
                    continue;
                }
                op[0] = i;
                op[1] = secondInd;
                return op;
            }
        }


        return op;
    }



}
