package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> res = new PowerSet().subsets(nums);
        for (List<Integer> ar: res){
            for (int i: ar){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null||nums.length==0){
            return res;
        }
        List<Integer> buffer = new ArrayList<>();
        powerSetHelper(nums, buffer, res, 0);
        return res;
    }

    private void powerSetHelper(int[] nums, List<Integer> buffer, List<List<Integer>> res, int cur) {
        if (cur>= nums.length){
            res.add(new ArrayList<>(buffer));//deepcopy
            return;
        }
            buffer.add(nums[cur]);
            powerSetHelper(nums, buffer, res, cur+1);
            //buffer.remove(Integer.valueOf(nums[cur]));//backtrack
            buffer.remove(buffer.size()-1);
            powerSetHelper(nums, buffer, res, cur+1);
    }

    /**********Bit masking approach**********/

    private  void printPowerSet(char[] set) {

        int powSetCount = (int) Math.pow(2, set.length);
        System.out.println("Printing powerset with size: " + powSetCount);

        for (int cnt = 0; cnt < powSetCount; cnt++) {
            //check if ith bit is set in the counter i , if yes then print the ith char if the set

            for (int i = 0; i < set.length; i++) {
                if ((cnt & 1 << i) > 0) {//ith bit is set
                    System.out.print(set[i]);
                }
            }
            System.out.println();

        }

    }


}


