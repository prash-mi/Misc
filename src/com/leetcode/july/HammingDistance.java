package com.leetcode.july;

public class HammingDistance {
    public static void main(String[] args){
    System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {
        int dis=0, bits=32;
        for (int i = 0; i < bits; i++){
            if( (x & (1 << i)) != (y&(1<<i))){//!= operator is doing the logical XOR operations here, the same can be done using ^
                dis++;
            }
        }
        return dis;
    }
}
