package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleMeeting {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
    /*
    Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        if (schedule==null||schedule.size()==0){
            return new ArrayList<>();
        }

        List<Interval> intervals = new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        for (List<Interval> l: schedule){
            intervals.addAll(l);
        }
        Collections.sort(intervals, new Comparator<Interval>() {//sort in increasing order of start time
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int runningMax =Integer.MIN_VALUE;
        for (int i = 0; i < intervals.size()-1; i++){
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);
            runningMax = Math.max(runningMax, cur.end);
            if (runningMax < next.start){
                //there is a free interval between runningMax and next.start
                res.add(new Interval(runningMax, next.start));
            }

        }

    return res;
    }

}
