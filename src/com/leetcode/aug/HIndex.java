package com.leetcode.aug;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public static void main(String[] args){
    int[] ip = {3,0,6,1,5};
    System.out.println(new HIndex().hIndex(ip));
    }

    public int hIndex(int[] citations) {
        //Arrays.sort(citations, Collections.reverseOrder());
        int hIndex = 0 ;
        for (int i = 0; i < citations.length; i++){
            int h = i+1;
            if ( citations[i] <= i+1 && (citations.length - citations[i] ) < citations[i]){
                hIndex = citations[i];
            }
        }
    return hIndex;
    }

}
