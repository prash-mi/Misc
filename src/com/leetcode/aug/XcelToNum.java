package com.leetcode.aug;

public class XcelToNum {
    public static void main(String[] args){

    }

    public int titleToNumber(String s) {

        int num =0;
        for (int i = s.length()-1; i >= 0; i--){
            num += (Math.pow(26, (s.length()-i-1))*(s.charAt(i)-64));
        }
        return num;
    }

}
