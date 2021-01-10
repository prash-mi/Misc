package com.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSub {
    /*
    Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
     */

    public static void main(String[] args){
        System.out.println(new LongestSub().lengthOfLongestSubstring("abba"));
    }

//Time O(n). Space O(m), where m is the number of unique chars, which is constant for ASCII strings
    //sliding window approach
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxSub = 1;
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, right = 1;
        lastSeen.put(s.charAt(0), 0);//first char
        while(right<s.length()){
            char c = s.charAt(right);
            if (lastSeen.containsKey(c)){//repeating char, advance left
                left = Math.max(left, lastSeen.get(c)+1);//IMP: left should not go back incase we found a char which was seen even earlier
            }

            maxSub = Math.max(maxSub, (right-left+1));

            lastSeen.put(c, right);//update last seen
            right++;
        }
        return maxSub;
    }




/* //Bruitforce O(n^2) solution
public int lengthOfLongestSubstring(String s) {
        if (s==null || s.equals("")){
            return 0;
        }
        int max = 1;
        for (int i =0; i < s.length(); i++){
            String sub = s.substring(i, s.length());
            max = Math.max(max, getMaxLen(sub));
        }
        return max;
    }

    int getMaxLen(String s){
        int maxLen = 1;

        Set<Character> seen = new HashSet<>();
        for (int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!seen.contains(c)){
                seen.add(c);
                maxLen = Math.max(maxLen, seen.size());
            }else {//current char is a repeating char, see if we can start a bigger string here.
                break;
               // seen.clear();
              //  seen.add(c);
            }
        }
        return maxLen;
    }*/

}
