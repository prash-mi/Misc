package com.leetcode.july;

import java.util.*;

/*
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */
public class TopKFrequentElements {
    public static void main(String[] args){
        int[] ip = {4,1,-1,2,-1,2,3}; int k = 2;
        /*
        Input:
[4,1,-1,2,-1,2,3]
2
Output:
[-1,1]
Expected:
[-1,2]
         */
        int[] top = new TopKFrequentElements().topKFrequent(ip, k);
        for (int i: top){
            System.out.println(i);
        }
    }

    private PriorityQueue<ICPair> topK = null;
    public  int[] topKFrequent(int[] nums, int k) {

        Map<Integer, ICPair> seen = new HashMap<>();
        topK = new PriorityQueue<>(k);//Minheap

        for(int i: nums){
            if(seen.containsKey(i)){
                ICPair cur = seen.get(i);
                cur.cnt = cur.cnt+1;
                seen.put(i, cur);
            }else {
                ICPair cur = new ICPair(i, 1);
                seen.put(i, cur);
            }
        }
        for(Integer key: seen.keySet()){
            addToMinHeap(seen.get(key), k);
        }
        int[] topKInt = new int[k];
        int cnt = 0;

       /* while (!topK.isEmpty()){ // This is expensive as the Heap heapifies on every poll
            topKInt[cnt++] = topK.poll().num;
        }*/

       Iterator<ICPair> it = topK.iterator();
       while (it.hasNext()){
           topKInt[cnt++] = it.next().num;
       }

        return topKInt;
    }

    public void addToMinHeap(ICPair cur, int k){

        if(topK.size()<k){
            topK.offer(cur);
            return;
        }

        ICPair min = topK.peek();
        if(cur.cnt>min.cnt){
            topK.remove(min);//throw it
            topK.offer(cur);
        }
    }

}

class ICPair implements Comparable<ICPair>{
    int num, cnt;
    ICPair(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(ICPair in) {
        return   -1*(in.cnt-this.cnt);
    }
}
