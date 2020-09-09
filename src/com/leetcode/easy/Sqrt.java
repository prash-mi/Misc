package com.leetcode.easy;

public class Sqrt {
    public static void main(String[] args){
        System.out.println(new Sqrt().mySqrt(6));
        System.out.println(new Sqrt().mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int min = 1, max = x, mid;
        int res = -1;
        while (min<=max){
            mid = min + (max-min)/2;
            long sq = (long)mid*(long)mid;
            if (sq==x){
                return mid;
            }else if(sq<x){//go right
                res = mid;
                min = mid+1;
            }else{//go left
                max = mid-1;
            }
        }
        return res;
    }
}
