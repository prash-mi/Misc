package com.leetcode.aug;



import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> num = new FindDuplicates().findDuplicates(nums);

        for (int i: num){
            System.out.println(i);
        }

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dupNum = new ArrayList<>();
        for (int num: nums){
            int ind = Math.abs(num)-1;
            if(nums[ind]>0){//it's unmarked, mark it negative;
                nums[ind] *= -1;
            }else {//aready marked and it's a duplicate
                dupNum.add(Math.abs(num));
            }
        }
        return dupNum;
    }

}
