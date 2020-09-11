package com.leetcode.medium;

import com.leetcode.easy.Sqrt;

public class SearchRotatedSorted {

    public static void main(String[] args) {
        int[] ip = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        int[] ip2 = {3,1};
       // System.out.println(new SearchRotatedSorted().search(ip, 2));
        System.out.println(new SearchRotatedSorted().search(ip2, 1));
    }

    //[0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]
    public int search(int[] nums, int target) {

        //BSearch th point of rotation
        int left = 0, right = nums.length - 1, mid, pivot = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {//just in case this happens to be the target
                return mid;
            }

            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]
                    && mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {//mid is the rotation point
                pivot = mid;
                break;
            } else if (nums[mid] >= nums[0] &&
                    nums[nums.length - 1] <= nums[mid]) { //we are in left subarray, go to right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int index;
        if ((index=bSearch(nums, 0, pivot, target)) != -1){//search in left sub array
            return index;
        }else if ((index=bSearch(nums, pivot+1, nums.length-1, target)) != -1){//search in right subarray
            return index;
        }

        return -1;
    }

    private int bSearch(int[] nums, int left, int right, int target){
        int mid;
        while (left<=right){
            mid = left +(right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){//go right
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
