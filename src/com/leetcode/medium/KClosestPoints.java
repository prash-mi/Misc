package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args){
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] kClosest = new KClosestPoints().kClosest(points, 2);
        for (int[] pt: kClosest){
            System.out.println(Arrays.toString(pt));
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        if(points==null || points.length==0||k<0){
            return new int[][]{};
        }
        int[][] res = new int[k][2];

        PriorityQueue<int[]> kClosest = new PriorityQueue((p1, p2) -> (originDistance(p2) - originDistance(p1)));//max heap, biggest elements will bubbleup at the top

        for (int[] point:points){
            kClosest.add(point);
            if (kClosest.size()>k){
                kClosest.poll();//remove the top element
            }
        }

        int ind = 0;
        while (!kClosest.isEmpty()){
            res[ind++] = kClosest.poll();
        }
        return res;
    }

    private int originDistance(Object p) {
        int[] pt = (int[]) p;
        return ((pt[0]*pt[0]) + (pt[1]*pt[1]));//the actual distance is square root of this value, but avoiding sqrt as it was causing testcases to fail due to loss of precision while conversion back to int
    }
}
