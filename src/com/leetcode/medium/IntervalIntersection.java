package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {//these are sorted by starting point
        if (A==null||B==null||A.length==0||B.length==0){
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<A.length && p2<B.length){
            if (overlap(A[p1], B[p2])){
                res.add(new int[]{Math.max(A[p1][0], B[p2][0]), Math.min(A[p1][1], B[p2][1])});
            }
            //increment one of the pointers, the interval which ends first can be incremented
            if (A[p1][1] < B[p2][1]){
                p1++;
            }else {
                p2++;
            }
        }
        int[][] resAry = new int[res.size()][];
        for (int i=0; i< res.size(); i++){
            resAry[i] = res.get(i);
        }
        return resAry;
    }
    private boolean overlap(int[] in1, int[] in2) {
        return !(in1[1] < in2[0] || in2[1] < in1[0]);
    }
}