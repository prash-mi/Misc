package com.leetcode.july;

import java.util.Arrays;

public class ScheduleTasks {
    public static void main(String[] args){
        char[] ip1 = {'A','A','A','B','B','B', 'C'};
        System.out.println(new ScheduleTasks().leastInterval(ip1, 2));
        System.out.println(new ScheduleTasks().leastInterval(ip1, 0));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);//it sorts the array in ascending order, max occurring element is at the last index.
        int maxOccurence = map[map.length-1];// this will be the last element
        int maxIdleTime  = n * (maxOccurence -1); // Ex for AAA & n=2 => A idle idle A idle idle A

        for (int i = map.length-2; i>=0; i--){
            if (map[i] == 0){
                break;
            }
            maxIdleTime -= (map[i] == maxOccurence? (map[i]-1): map[i]);//subtract the char count from the max idle, as we don't need to leave the CPU idle. if occurrence == max Occurrence then reduce one as we need not leave the CPU idle after the last instruction
        }
        maxIdleTime = maxIdleTime<0?0:maxIdleTime;//idle can't be less than 0

        return (maxIdleTime+tasks.length);// total would be the actual idle time + the total tasks as input
    }
}
