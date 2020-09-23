package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajorityElement2 {
    public static void main(String[] args){
        int[] ip1 = {3,1,1,1,3,2,2,2};
        List<Integer> res = new MajorityElement2().majorityElement(ip1);
        for (int i: res){
            System.out.println(i);
        }
    }

    public List<Integer> majorityElement(int[] nums) {

        int major1=-1, major1Cnt=0, major2=-1, major2Cnt=0;
        List<Integer> res = new ArrayList<>();

        for (int num: nums){
            if (major1Cnt==0){
                major1Cnt++;
                major1=num;
                continue;
            }
            if (major2Cnt==0){
                major2Cnt++;
                major2=num;
                continue;
            }


            if (num==major1){
                major1Cnt++;
                continue;
            }else {
                major1Cnt--;
            }

            if (num==major2){
                major2Cnt++;
            }else {
                major1Cnt--;
            }
        }

        if (major1Cnt>0){
            res.add(major1);
        }
        if (major2Cnt>0){
            res.add(major2);
        }

    return res;
    }

}
