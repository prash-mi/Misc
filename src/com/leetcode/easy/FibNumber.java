package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FibNumber {
    Map<Integer, Integer> mem = new HashMap();
    public int fib(int N) {
        if(N<2){
            return N;
        }

        if(mem.containsKey(N)){
            return mem.get(N);
        }
        int res = fib(N-1)+fib(N-2);
        mem.put(N, res);
        return res;
    }
}
