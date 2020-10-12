package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
    //O(n) time and O(1) space as seem set will just have 26 entries in the worst case
    public boolean buddyStrings(String A, String B) {
        if (A==null||B==null||A.length()!=B.length()||A.length()<2){
            return false;
        }
        int[] swap = new int[3];
        int cnt=0;
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i)!=B.charAt(i)){
                swap[cnt++] = i;
            }
            if (cnt == 3){
                return false;
            }
        }
        if(cnt == 0){//there is a case like aa and aa. OR abab and abab. so we have to see if any two  chars are the same
            Set<Character> seen = new HashSet();
            for (int i = 0; i < A.length(); i++){
                if (seen.contains(A.charAt(i))){
                    return true;
                }else {
                    seen.add(A.charAt(i));
                }
            }
        }
        if (cnt == 2){//compare these chars
            return (A.charAt(swap[0]) == B.charAt(swap[1]) && A.charAt(swap[1]) == B.charAt(swap[0]));
        }
        return false;
    }
}
