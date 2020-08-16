package com.leetcode.aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingInterval {

    //
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2},{1,2}};
        int[][] intervals3 = {{1,2},{10,12}};
       System.out.println(new NonOverlappingInterval().eraseOverlapIntervals(intervals));//1
        System.out.println(new NonOverlappingInterval().eraseOverlapIntervals(intervals2));//3
        System.out.println(new NonOverlappingInterval().eraseOverlapIntervals(intervals3));//0
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        /*Greedy approach.
            Sort by starting point
            parse linearly with a previous pointer. In case of overlap
                Choose one which finishes early, so that we leave more range which reduces overlaps
        */

        if (intervals == null || intervals.length <= 1){
            return 0;
        }

        List<Interval> ints = new ArrayList<>();
        int remove = 0;
        for(int[] i:intervals){
            ints.add(new Interval(i[0],i[1]));
        }
        Collections.sort(ints);

        Interval prev = ints.get(0), cur = null;

        for (int i = 1; i <ints.size(); i++){
            cur = ints.get(i);
            if (ovelap(prev, cur)){
                remove++;//atleast one interval will be removed.
                if (prev.end >= cur.end){//prev pointer is updated
                    prev = cur;
                }//else prev stays where it is as prev's end is before cur's end
            }else {//no overlap, simply move forward
                prev = cur;
            }
        }

    return remove;
    }

    private boolean ovelap(Interval prev, Interval cur){
        return prev.end > cur.start;
    }
}

class Interval implements Comparable<Interval>{
    int start, end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }
}
