package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args){
        List<Integer> res = new SequentialDigits().sequentialDigits(1000, 13000);
        for (int i: res){
            System.out.println(i);
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        int[] num = getFirst(low);
        int numI = getInt(num);

        while (numI <= high){
            if (numI>=low && numI<=high){
                res.add(numI);
            }
            numI = getNext(numI); 
        }

        return res;
    }

    private int getNext(int numI) {
        //1234 -> 2345
        int[] numAr;
        if (numI%10 == 9){//can't add 1, eg: 789
            int len = String.valueOf(numI).length();
            int low = (int) Math.pow(10, len);
            numAr = getFirst(low);
        }else {
            numAr = getIntAr(numI);
            //now add 1 in place//overflow won't occur
            for (int i = 0; i < numAr.length; i++){
                numAr[i] = numAr[i]+1;
            }

        }
        return getInt(numAr);
    }

    private int[] getIntAr(int numI) {
        int len = String.valueOf(numI).length();
        int[] num = new int[len];
        for (int i = len-1; i >= 0; i--){
            num[i] = numI%10;
            numI /= 10;
        }
        return num;
    }

    private int getInt(int[] num) {
        int n = 0;
        int m = 1;
        for (int i = num.length-1; i>=0; i--){
            n += (num[i]*m);
            m *= 10;
        }
        return n;
    }

    private int[] getFirst(int low) {
        int len = String.valueOf(low).length();
        int[] num = new int[len];
        for (int i = len-1; i >= 0; i--){
            num[i] = i+1;
        }
     return num;
    }
}