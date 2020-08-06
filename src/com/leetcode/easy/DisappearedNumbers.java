package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;


public class DisappearedNumbers {
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> num = new DisappearedNumbers().findDisappearedNumbers(nums);

        for (int i: num){
            System.out.println(i);
        }


    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> misNum = new ArrayList<>();
        for (int num: nums){
            int ind = Math.abs(num)-1;
            if(nums[ind]>0){//it's unmarked, mark it negative;
                nums[ind] *= -1;
            }
        }
        for (int i = 0; i <nums.length; i++){//all the index with negative values correspond to the disappeared numbers
            if (nums[i] >0 ){
                misNum.add(i+1);
            }
        }
        return misNum;
    }

}
