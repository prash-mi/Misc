package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class NumFreqPair{
        int num, freq;
        NumFreqPair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if (nums==null || nums.length==0){
            return new int[]{};
        }

        int[] res = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<NumFreqPair> minHeap = new PriorityQueue((numFreq1, numFreq2)->(((NumFreqPair)numFreq1).freq - ((NumFreqPair)numFreq2).freq ));//Min heap
        for (int n: nums){
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }

        for (int key: freq.keySet()){
            minHeap.add(new NumFreqPair(key, freq.get(key)));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int ind = 0;
        while (!minHeap.isEmpty()){
            res[ind++] = minHeap.poll().num;
        }
        return res;
    }
}
