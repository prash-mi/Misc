package com.leetcode.july;

import java.util.ArrayList;
import java.util.List;

public class SuperSet {
    public static void main(String[] args){
    int[] ar = {1,2,3};
        List<List<Integer>> superSet = subsets(ar);
        for (List<Integer> l:superSet){
            for (Integer i: l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
           List<List<Integer>> superSet = new ArrayList<>();
           Integer[] buffer =new Integer[nums.length];
           getSuperSet(nums, superSet, buffer, 0);
           return superSet;
    }

    public static void getSuperSet(int[] nums,   List<List<Integer>> superSet, Integer[] buffer, int cur){
        if(cur == nums.length){
            superSet.add(getList(buffer));//deepcopy
        }else{
            //take cur ones and leave cur ones
            buffer[cur] = null;
            getSuperSet(nums, superSet, buffer, cur+1);
            buffer[cur] = nums[cur];
            getSuperSet(nums, superSet, buffer, cur+1);
        }
    }

    public static List<Integer> getList(Integer[] buff){
        List<Integer> sub = new ArrayList<>();
            for (Integer i: buff){
                if(i!= null){
                    sub.add(i);
                }
            }
        return sub;
    }


}
