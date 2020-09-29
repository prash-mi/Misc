package com.leetcode.medium;
/*
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
public class SubAryPrdLesK {

    public static void main(String[] args){
        int[] ip = {10, 5, 2, 6};
        int[] ip2 = {10, 5, 200, 6};
        System.out.println(new SubAryPrdLesK().numSubarrayProductLessThanK(ip, 100));
        System.out.println(new SubAryPrdLesK().numSubarrayProductLessThanK(ip2, 100));
    }

    //Time O(n) space O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums==null || nums.length == 0){
            return 0;
        }
        int totProd = 0; long curProd = 1;
        int left = 0, right = 0; //pointers
        while (right < nums.length){
            if (nums[right] < k){
                totProd++;//current element is a subary
            }
            if(curProd * nums[right] < k){
                totProd += (right-left); //these many new subarays can be formed
            }else {//move left towards right
                while (left< right){
                    curProd /= nums[left];
                    left++;
                    if(curProd * nums[right] < k){
                        totProd += (right-left);
                        break;
                    }
                }
            }
            curProd *= nums[right];
            right++;
        }
        return totProd;
    }
}
