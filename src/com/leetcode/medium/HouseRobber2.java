package com.leetcode.medium;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums == null||nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        //do two passes, start from 0 till (n-2)th index and then from 1 till n-1th index and see which gives most value
        int rob1 = robHelper(nums, 0, nums.length-2);
        int rob2 = robHelper(nums, 1, nums.length-1);
        return Math.max(rob1, rob2);
    }
    public int robHelper(int[] nums, int start, int end) {
        int aux1=0, aux2 = nums[start];
        for (int i =start+1; i <= end; i++){
            int temp = aux2;
            aux2 = Math.max(aux2, (aux1+nums[i]));
            aux1 = temp;
        }
        return aux2;
    }
}
