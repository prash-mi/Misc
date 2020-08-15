package com.leetcode.aug;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = 0;
        Map<Character, Integer> charCnt = new HashMap<>();
        for (int i = 0; i <s.length(); i++){
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0)+1);
        }
        boolean takenSingleChar = false;
        for (char c:charCnt.keySet()){
            int cnt = charCnt.get(c);
            if (cnt%2 == 1 && !takenSingleChar){
                takenSingleChar = true;
                len++;
            }
            int pairs = cnt/2;
            len += (pairs*2);
        }
        return len;
    }
}
