package com.leetcode.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    //return the maximum in the sliding window in O(n) time and O(k) space - This solution is O(n) as the elements in the deque are read atmost twice, as they are kept in descending order
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null||nums.length<k){
            return new int[]{};
        }
        Deque<Integer> deq = new LinkedList<>();//This Dequeue will hold the indexes of the element in the window K
        int[] slidingMaxes = new int[nums.length-k+1];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++){
            processCurrentElement(nums, deq, i, k);//delete elements <= the current element from the last of the queue, remove the first index if it is now out of the window K, add the current element. Thus keeping the queue sorted
            if (i >= k-1){
                slidingMaxes[cnt++] = nums[deq.getFirst()];//first is always the max as the queue is always sorted
            }
        }
        return slidingMaxes;
    }
    //delete elements <= the current element from the last of the queue, remove the first index if it is now out of the window K, add the current element. Thus keeping the queue sorted
    private void processCurrentElement(int[] nums, Deque<Integer> deq, int i, int k) {
        while (!deq.isEmpty() && nums[deq.getLast()] <= nums[i]){//removing the elements smaller or equal to the current element, as they can't be maximum for the given windows, given ith element is the most recent
            deq.removeLast();
        }

        //remove the fist element if it has moved out of the window
        if (!deq.isEmpty() && i-k == deq.getFirst()){
            deq.removeFirst();
        }

        //add the last index
        deq.addLast(i);
    }
}
