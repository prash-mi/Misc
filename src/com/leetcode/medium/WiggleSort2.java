package com.leetcode.medium;

import java.util.Arrays;

public class WiggleSort2 {

    public static void main(String[] args){
        int[] ip = {1, 5, 1, 1, 6, 4};
        new WiggleSort2().wiggleSort(ip);
        System.out.println(Arrays.toString(ip));
    }

    //O(n log n) time and O(n) space
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 0){
            return;
        }
        int[] auxNums = Arrays.copyOf(nums, nums.length);//copy of the original array
        Arrays.sort(auxNums);
        int right = auxNums.length-1;
        //fill the odd length of the array its with the largest values
        for (int i = 1; i < auxNums.length; i+=2){
            nums[i] = auxNums[right--];
        }

        //fill the even elements now
        for (int i = 0; i < auxNums.length; i+=2){
            nums[i] = auxNums[right--];
        }

    }


}
