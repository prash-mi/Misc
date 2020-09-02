package com.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {
    //1,2,3 → 1,3,2
    //3,2,1 → 1,2,3
    //1,1,5 → 1,5,1
    //15864321 - > 16132458
    //12345 -> 12354

    public static void main(String[] args){
        int[] ip = {1,5,8,6,4,3,2,1};
        new NextPermutation().nextPermutation(ip);
    }

    public void nextPermutation(int[] nums) {
        int lowInd = -1;
        for (int i = nums.length-1; i >=1; i--){
            if (nums[i-1] < nums[i]){
                lowInd = i-1;
                break;
            }
        }
        if (lowInd == -1){//array is in decreasing order, return in the increasing order
            Arrays.sort(nums);
            return;
        }

        //swap lowInd with the next biggest value
        int nextMinInd = lowInd+1;
        for (int i = lowInd+1; i < nums.length; i++){
            if (nums[i] > nums[lowInd] && nums[i] <= nums[nextMinInd]){
                nextMinInd = i;
            }
        }
        swap(nums, lowInd, nextMinInd);
        //now sort the array from lowInd+1 till nums.length-1 in assending order. This is same to reversing the sub-array
        int left = lowInd+1, right = nums.length-1;
        while (left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
        print(nums);
    }

    private void swap(int[] nums, int lowInd, int nextMinInd) {
        int temp = nums[lowInd];
        nums[lowInd] = nums[nextMinInd];
        nums[nextMinInd] = temp;
    }

    private void print(int[] nums){for (int i:nums) System.out.print(i+", "); }
}
