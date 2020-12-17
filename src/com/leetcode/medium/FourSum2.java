package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    //Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
    //O(n^2) time and space
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A==null || A.length == 0){//its given that all arrays will have the same length
            return 0;
        }
        Map<Integer, Integer> abSum = new HashMap<>();
        int tupleCnt = 0;
        for (int i: A){
            for (int j: B){
                int sum = i+j;
                abSum.put(sum, abSum.getOrDefault(sum, 0)+1);//sum is-to the occurance of the sum
            }
        }

        for (int i: C){
            for (int j: D){
                int reqSum = 0 -  (i+j);
                tupleCnt += (abSum.getOrDefault(reqSum, 0));
            }
        }
        return tupleCnt;
    }
}
