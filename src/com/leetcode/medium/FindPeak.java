package com.leetcode.medium;

public class FindPeak {
    /*
        Input: nums = [1,2,1,3,5,6,4]
        Output: 1 or 5
        Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
     */


    //O(log n) time and O(1) space
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length<2){
            return 0;
        }
        int left=0, right = nums.length-1, mid;
        while (left<right){
            mid = left + (right-left)/2;
            if (nums[mid] < nums[mid+1]){//increasing sub array, go right
                left = mid+1;
            }else {
                right = mid;
            }
        }
       return left;
    }

    //more verbose O(log n) solution, above one is more optimised
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length<2){
            return 0;
        }
        int left=0, right = nums.length-1, mid, prev, next;
        while (left<right){
            mid = left + (right-left)/2;
            prev = mid-1>=0?nums[mid] - nums[mid-1] : 1;
            next = mid+1 < nums.length?nums[mid+1] - nums[mid]: -1;
            if (prev > 0 && next < 0){
                return mid;
            }else if(prev>0 && next > 0){//increasing  subarray, go right
                left = mid+1;
            }else{
                right = mid;
            }
        }
       return left;
    }
}
