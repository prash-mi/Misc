package com.leetcode.medium;

public class MinInRotatedAry {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length-1, mid;
        while (left < right){

            mid = left + (right-left)/2;
            if (nums[mid]>=nums[0] && nums[mid] < nums[nums.length-1]){
                return nums[0];
            }else if (nums[mid] >= nums[0]){//go right
                left=mid+1;
            }else {
                right = mid;
            }
        }
        //left will be at the min element at this point in time
        return nums[left];
    }
}