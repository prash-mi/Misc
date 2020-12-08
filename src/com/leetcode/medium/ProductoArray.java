package com.leetcode.medium;
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Please solve it without division and in O(n).
*/
public class ProductoArray {
    //Approach without using division in O(n) time
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <=1){
            return nums;
        }
        int[] auxNums = new int[nums.length];
        int leftMul = 1, rightMul=1;
        //Consider we have input array [a, b, c, d], then we will do the first pass and compose the auxNums as [1, a, ab, abc] using leftMul (rolling multiplyer
        //then we will do the second pass and compose the auxNums as [bcd, acd, abd,abc] using rightMul

        //First Pass - first pass and compose the auxNums as [1, a, ab, abc] using leftMul
        for (int i = 0; i < auxNums.length; i++){
            auxNums[i] = leftMul;
            leftMul *= nums[i];//rolling multiplyer
        }

        //second pass
        for (int i = auxNums.length-1; i>=0; i--){//compose the auxNums as [bcd, acd, abd,abc] using rightMul
            auxNums[i] *= rightMul; //IMP - It's *= here (take an input like [a, b, c, d] to emulate it
            rightMul *= nums[i];
        }

        return auxNums;
    }
}
