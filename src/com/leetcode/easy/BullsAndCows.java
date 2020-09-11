package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    /*
    Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
     */
    public String getHint(String secret, String guess) {
        //lets count bulls first and create a Map for cows
        int bulls = 0, cows=0;
        Map<Character, Integer> unMatched = new HashMap<>();
        Set<Integer> bullIndexes = new HashSet<>();
        for (int in =0; in< secret.length();in++){
            if (secret.charAt(in) == guess.charAt(in)){
                bulls++;
                bullIndexes.add(in);
            }else {
                unMatched.put(secret.charAt(in), unMatched.getOrDefault(secret.charAt(in), 0)+1);
            }
        }
        for (int in =0; in< guess.length();in++){
            if (bullIndexes.contains(in)){//no need to match these
                continue;
            }
            if(unMatched.containsKey(guess.charAt(in))){
                cows++;
                int matches = unMatched.get(guess.charAt(in));
                if (matches==1){
                    unMatched.remove(guess.charAt(in));
                }else {
                    unMatched.put(guess.charAt(in), matches-1);
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}
