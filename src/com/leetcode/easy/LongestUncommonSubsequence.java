package com.leetcode.easy;

public class LongestUncommonSubsequence {
    public int findLUSlength(String a, String b) {
    if (a==null||b==null){
        return a==null&&b==null?0:(a==null?b.length():a.length());
    }
    //now there ate 3 cases
        //both are equal
        if (a.equals(b)){
            return -1;//no uncommon subsequence possible
        }
        //the bigger string is the longest uncommon sub sequence
        if (a.length()!=b.length()){
            return Math.max(a.length(), b.length());
        }
        return a.length();//both the strings are equal in length, return the length of anyone as both are uncommon
    }
}
