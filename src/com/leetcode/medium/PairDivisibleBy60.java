package com.leetcode.medium;

public class PairDivisibleBy60 {
    /*
    Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
     */

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0 ){
            return 0;
        }
        int cnt = 0;
        int[] remainders = new int[60];//remainder will range from 0 - 59

        for (int t: time){
            int rem = t%60;
            if (rem == 0){//number is 60, it can be paired with all the multiple of 60 which will be @ remainders[0]
                cnt += remainders[0];
            }else {//the number can be paired with other numbers with remainder = 60-rem. For example number 80 has remainder 20 and it can be paired with number 100 which has 40 remainder (60-20)
                cnt += remainders[60-rem];
            }
            remainders[rem]++;
        }

        return cnt;
    }
}
