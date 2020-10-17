package com.leetcode.easy;

//O(n) time and space. Space can be optimised to O(1) by maintaining two variables instead of the aux array
public class HouseRobber1 {
    public int rob(int[] nums) {
        if(nums == null||nums.length==0){
            return 0;
        }
        int[] aux = new int[nums.length+1];
        aux[1] = nums[0];
        for (int i =1; i < nums.length; i++){
            aux[i+1] = Math.max(aux[i], (aux[i-1]+nums[i]));//see if we are getting the max by skipping the current house (i+1); that is copy the previous value. Or
        }
        return aux[aux.length-1];
    }
}