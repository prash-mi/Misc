package com.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicates3 {

    //Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
    public static void main(String[] args){
/*
Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

[-2147483648,2147483647]
1
1
false
 */
        int[] ip1 = {1,2,3,1}, ip2={1,0,1,1}, ip3={1,5,9,1,5,9}, ip4={-2147483648,2147483647};
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicate(ip1, 3,0));
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicate(ip2, 1,2));
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicate(ip3, 2,3));
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicate(ip4, 1,1));

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Sliding window implementation, we will have k elements in the window. Find the ceiling and floor of the current element and if it's withing t distance from the current element then we have found a solutions
        TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i< nums.length; i++){
            Integer floor=null, celiling=null;
            if((celiling=window.ceiling(nums[i]))!=null && celiling <= nums[i] +t ){
                return true;
            }
            if((floor=window.floor(nums[i]))!=null &&   floor>= nums[i]-t  ){
                return true;
            }

            window.add(nums[i]);
            if (i-k>=0){
                window.remove(nums[i-k]);//slide the window
            }
        }
    return false;
    }
}
