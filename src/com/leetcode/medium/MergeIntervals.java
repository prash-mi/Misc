package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] inter = {{1,3},{2,6},{8,10},{15,18}};
        int[][] inter2 = {{1,4},{0,4}};
        int[][] merged = new MergeIntervals().merge(inter2);
        for (int[] i: merged){
            System.out.println(i[0]+" "+i[1]);
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals==null|| intervals.length==0){
            return new int[0][];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];//sort by starting point ascending
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i=0; i <=intervals.length-2; i++){
            int[] merged = mergeIfOverlap(intervals[i], intervals[i+1]);
            if (merged == null){//didn't overlap
                res.add(intervals[i]);
            }else {
                intervals[i+1] = merged;//as even i+2 could match with the currently merged element
            }
        }
        res.add(intervals[intervals.length-1]);//
        int[][] resAry = new int[res.size()][];
        for (int i=0; i < res.size(); i++){
            resAry[i]=res.get(i);
        }
        return resAry;
    }

    private int[] mergeIfOverlap(int[] in1, int[] in2){
        if (in2[0] >= in1[0] && in2[0]<=in1[1]){//overlaps
            return new int[]{in1[0], Math.max(in1[1], in2[1])};
        }
        return null;
    }
}
