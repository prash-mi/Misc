package com.leetcode.easy;

public class KthMissingPositive {
    public static void main(String[] args){
        System.out.println(new KthMissingPositive().findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(new KthMissingPositive().findKthPositive(new int[]{1,2,3,4}, 2));
    }
    public int findKthPositive(int[] arr, int k) {
        int totMis = 0;
        for(int i = 0; i < arr.length; i++){
            int mis = i==0?(arr[i]-1):(arr[i] - arr[i-1]-1);
            totMis += mis;
            if (totMis >= k){
                totMis = totMis - mis;
                return (i==0?0:arr[i-1]) + (k-totMis);
            }
        }
        return arr[arr.length-1] + (k-totMis);
    }
}
