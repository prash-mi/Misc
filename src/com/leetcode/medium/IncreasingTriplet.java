package com.leetcode.medium;

public class IncreasingTriplet {
    public static void main(String[] args){
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,3}));
    }
    public boolean increasingTriplet(int[] nums) {
        if (nums == null||nums.length < 3){
            return false;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n: nums){
            if (n < first){//this will be the min number seen so far
                first = n;
               // second = Integer.MAX_VALUE;// - IMP, ITS IMPORTANT NOT TO REST IT, AS EVEN IN CASE OF THE SAMPLE ABOVE, IF first is set to a lower value (-1), the logic would work
            }else if (n> first && n< second){
                second = n;//this is the second number which is greater than the running min first
            }else if (n > first && n > second){//this is the third number in the triplet
                return true;
            }
        }
        return false;
    }
}
