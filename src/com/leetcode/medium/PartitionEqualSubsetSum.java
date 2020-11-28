package com.leetcode.medium;


public class PartitionEqualSubsetSum {
    public static void main(String[] args){
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {1,5,11,5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {1,3,4,4}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99}));
    }

    // Time complexity without memoisation would be 2^n, with memo its O(n * subSetsum) ; n= nums.length

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int n:nums){
            sum += n;
        }
        if (sum%2 ==1){//odd sum cannot be divided
            return false;
        }

        ///practically a HashMap can be used as memo to remember result against remainingSum-rightIndex pair
        Boolean[][] memo = new Boolean[(sum/2)+1][nums.length];
        return canPartitionDFS(nums, sum/2, nums.length-1, memo);
    }

    private boolean canPartitionDFS(int[] nums, int remainingSum, int rightIndex, Boolean[][] memo) {

        if (remainingSum == 0){//found a solution
            return true;
        }
        if (rightIndex<0 || remainingSum <0){
            return false;
        }
        if (memo[remainingSum][rightIndex]!=null){//this solution has already been calculated, return it
            return memo[remainingSum][rightIndex];
        }

        boolean selectRightIndex = canPartitionDFS(nums, remainingSum - nums[rightIndex], rightIndex-1, memo);//selecting the element at rightIndex, so its value is deducted from remainingSum
        boolean notSelectRightIndex = canPartitionDFS(nums, remainingSum , rightIndex-1, memo);//skipping the element at rightIndex

        memo[remainingSum][rightIndex] = selectRightIndex || notSelectRightIndex;

        return selectRightIndex || notSelectRightIndex;
    }

}
