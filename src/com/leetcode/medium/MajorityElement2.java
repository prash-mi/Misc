package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */

//using  Boyer-Moore Voting Algorithm - Time O(n) space O(1)
public class MajorityElement2 {
    public static void main(String[] args){
        int[] ip1 = {3,1,1,1,3,2,2,2};
        List<Integer> res = new MajorityElement2().majorityElement(new int[]{1,2,2,3,2,1,1,3});
        for (int i: res){
            System.out.println(i);
        }
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums==null||nums.length==0){
            return new ArrayList<>();
        }
        Integer major1=null, major1Cnt=0, major2=null, major2Cnt=0;
        List<Integer> res = new ArrayList<>();

        for (int num: nums){
           if (major1!= null && num == major1){
                major1Cnt++;
            }else if(major2!= null && num == major2){
                major2Cnt++;
            } else if (major1 == null){
                major1 = num;
                major1Cnt = 1;
            }else if (major2 == null ){
                major2 = num;
                major2Cnt = 1;
            }else {//decrement both the counters
                major1Cnt--;
                major2Cnt--;

                if (major1Cnt==0){
                    major1=null;
                }

                if (major2Cnt==0){
                    major2=null;
                }
            }
        }
//now verify if major1 and major2 has more than n/3 occurences
        int m1 =0, m2=0;
        for (int num: nums){
            if (major1!= null && major1==num){
                m1++;
            }
            if (major2!= null &&major2==num && major2!= major1){
                m2++;
            }
        }

        if (m1> nums.length/3){
            res.add(major1);
        }

        if (m2> nums.length/3){
            res.add(major2);
        }

    return res;
    }

}
