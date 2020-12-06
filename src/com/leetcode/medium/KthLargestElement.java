package com.leetcode.medium;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new KthLargestElement().findKthLargest(nums, 4));

    }

    //returns the kth largest element from the end, including duplicates
    public int findKthLargest(int[] nums, int k) {
        if (nums==null || nums.length==0){
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue((i1, i2)->((Integer)i1- (Integer) i2));//Min heap, will hold the k unique largest elements
        for (int n: nums){
            minHeap.add(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }

        }
        return minHeap.peek();
    }
}
