package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s==null || t==null || s.length()!=t.length()){
            return false;
        }
        Map<Character, Character> stMap = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if ((stMap.containsKey(sChar) && stMap.get(sChar) != tChar) ||
                    (!stMap.containsKey(sChar) && seen.contains(tChar))){
                return false;
            }else {
                stMap.put(sChar, tChar);
                seen.add(tChar);
            }
        }
        return true;
    }

}
