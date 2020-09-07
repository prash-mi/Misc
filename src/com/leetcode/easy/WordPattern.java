package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    /*
    Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> charToStr = new HashMap<>();
        Set<String> seen = new HashSet<>();
        String[] words = str.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        for (int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if ((charToStr.containsKey(ch) && !charToStr.get(ch).equals(words[i])) ||
                   ! charToStr.containsKey(ch) && seen.contains(words[i])) {
                return false;
            }else {
                charToStr.put(ch, words[i]);
                seen.add(words[i]);
            }
        }
        return true;
    }
}
