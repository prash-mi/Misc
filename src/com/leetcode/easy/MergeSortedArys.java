package com.leetcode.easy;

public class MergeSortedArys {
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return;
        }
//start from the right and keep moving the biggest element to the right
        int p1 = m-1, p2=n-1, r=nums1.length-1;
        while (p2>=0 && p1>=0){
            if (nums2[p2]>=nums1[p1]){
                nums1[r--] = nums2[p2--];
            }else {
                nums1[r--] = nums1[p1--];
            }
        }
        //copy remaining elements from nums2 to nums1
        while (r>=0 && p2>=0){
            nums1[r--] = nums2[p2--];
        }

    }
}
