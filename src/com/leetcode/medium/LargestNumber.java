package com.leetcode.medium;

import java.util.*;

public class LargestNumber {
/*
Input: [3,30,34,5,9]
Output: "9534330"
 */
    public static void main(String[] args){
        int[] ip = {3,30,34,5,9};
        System.out.println(new LargestNumber().largestNumber(ip));
    }

    public String largestNumber(int[] nums) {
        if (nums==null||nums.length==0){
            return "";
        }
        List<Integer> numList = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        for (int i: nums){
            numList.add(i);
        }

        Collections.sort(numList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s2.compareTo(s1);
            }
        });

        if (numList.get(0) == 0){//largest number is zero, return zero. This will avoid "000" kind of outputs
            return "0";
        }

        for (int i:numList){
            res.append(i);
        }

    return res.toString();
    }
}
