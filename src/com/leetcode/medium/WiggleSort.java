package com.leetcode.medium;

//wigglesort - Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 0){
            return;
        }
        for (int i = 0; i < nums.length-1; i++){
            if (i%2 == 0 && nums[i] > nums[i+1]){//even places should be low
                swap(nums, i, i+1);
            }else if(i%2 == 1 && nums[i] < nums[i+1]){//odd places should be high
                swap(nums, i, i+1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
