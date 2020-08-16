package com.leetcode.medium;

import java.util.*;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
public class Permutation2 {

    public static void main(String[] args) {
        int[] ip1 = {1,2,1};

        List<List<Integer>> res = new Permutation2().permuteUnique(ip1);
        for (List<Integer> l : res){
            System.out.println(l);
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//sorting so that we can skip duplicates by comparing to the next element
        List<List<Integer>> res = new ArrayList<>();
        permuteUniqueHelper(nums, res, 0);
        return res;
    }

    private void permuteUniqueHelper(int[] nums, List<List<Integer>> res, int fix){

        if (fix>= nums.length){
            //copy the permutation
            List<Integer> tmp = new ArrayList<>();
            for (int i : nums){
                tmp.add(i);
            }
            res.add(tmp);
        }

        Set<Integer> seen = new HashSet<>();//remembers the seen ints at a given level of recursion

        for (int i = fix; i< nums.length; i++){

            if (seen.contains(nums[i])){
                continue;
            }
            seen.add(nums[i]);

            swap(nums,fix, i);
            permuteUniqueHelper(nums, res, fix+1);
            swap(nums,fix, i);//backtrack

        }

    }

    private void swap(int[] nums, int fix, int i){
        int tmp = nums[fix];
        nums[fix] = nums[i];
        nums[i] = tmp;
    }
}
