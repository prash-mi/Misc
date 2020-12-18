package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {
    public static void main(String[] args){
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInter = {4,8};
        int[][] merged = new InsertInterval().insert(intervals, newInter);
        for (int[] i:merged){
            System.out.print(Arrays.toString(i));
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null){// intervals.length could be 0
            return intervals;
        }
        if (intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> merged = new ArrayList<>();
        int idx = 0;
        //IMP - Copy the intervals before the newIntervals
        while(idx< intervals.length &&  intervals[idx][1] < newInterval[0]){//copy the intervals which are before the newInterval
            merged.add(intervals[idx++]);
        }

        while(idx< intervals.length){//process the remaining intervals
            int[] curInterval = intervals[idx++];
            if (newInterval!=null) {//not yet merged
                if (intersects(curInterval, newInterval)) {//merge
                    int[] curMerged = merge(curInterval, newInterval);
                    merged.add(curMerged);
                    newInterval = null;
                }else if (newInterval[1] < curInterval[0]){//newInterval should be added before the curInterval, as the input array is sorted
                    merged.add(newInterval);
                    merged.add(curInterval);
                    newInterval = null;
                }
            }else{//newInterval is merged
                int[] last = merged.get(merged.size()-1);//this wont be null
                if (intersects(last, curInterval)){
                    int [] curMerged = merge(last, curInterval);
                    merged.remove(merged.size()-1);
                    merged.add(curMerged);
                }else {
                    merged.add(curInterval);
                }
            }
        }

        if (newInterval!= null){//none of the intervals intersected and the newInterval was at the right extreme
                merged.add(newInterval);
        }

        int[][] mergedIntervals = new int[merged.size()][];
        for (int i=0; i <merged.size(); i++){
            mergedIntervals[i] = merged.get(i);
        }
        return mergedIntervals;
    }

    private int[] merge(int[] interval, int[] newInterval) {
        return new int[] {Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
    }

    private boolean intersects(int[] interval, int[] newInterval) {
        return !(newInterval[0] > interval[1] || newInterval[1]<interval[0]);
    }
}
