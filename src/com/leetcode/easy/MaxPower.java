package com.leetcode.easy;

//max number of consecutive chars
public class MaxPower {
    public int maxPower(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int max = 1, runningMax = 1;
        for(int i=1; i<s.length(); i++){
            if (s.charAt(i-1) == s.charAt(i)){
                runningMax++;
                max = Math.max(runningMax, max);
            }else{
                runningMax=1;//different char
            }
        }
    return max;
    }
}
