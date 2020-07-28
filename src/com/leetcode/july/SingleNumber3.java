package com.leetcode.july;

public class SingleNumber3 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9, 1,2,3,5,6,7,9};
        int diff[] = new SingleNumber3().singleNumber(nums);
        System.out.println(diff[0]+" "+diff[1]);
    }

    public int[] singleNumber(int[] nums) {

        if (nums == null || nums.length < 0){
            return nums;
        }

        int[] res = new int[2];

        int xorXY = 0;
        for (int i: nums){//xorXY will have the XOR of the two single numbers as the remaining numbers are in couple and they will negate themselves
            xorXY ^= i;
        }

        int lastDiffBitXY = xorXY & (-1*xorXY); //minus of a number is the 2's compliment (flip the bits) and add 1

        //now we have to bucket the numbers in two bucket on the basis of the lastDiffBitXY. If we & the numbers with lastDiffBitXY then if result is 1 then it goes to one bucket, else the other. The single numbers will be in different buckets are the had different bit @ lastDiffBitXY

        for (int i: nums){
            if ( (i & lastDiffBitXY) == 0){//different @ lastDiffBitXY
                res[0] ^= i;//XOR of numbers in pair and a single number is the single number itself
            }else {
                res[1] ^= i;
            }
        }

        return res;
    }
}
