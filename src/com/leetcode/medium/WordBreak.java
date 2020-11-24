package com.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //DP approach, Time (n^3) - two loops and one inner substring call
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;//you can break an empty string

        for (int wordEnd = 1; wordEnd <= s.length(); wordEnd++){
            for (int wordStart = 0; wordStart<wordEnd; wordStart++){
                String currentWord = s.substring(wordStart, wordEnd);
                if (canBreak[wordStart] && dict.contains(currentWord)){//if we can break the word till wordStart and the currentWord which is between wordStart
                                                        // and wordEnd is in dictionary then, the word till wordEnd can be broken
                    canBreak[wordEnd] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length-1];
    }

    /***Bruitforce approach***/

    public boolean wordBreakBruitforce(String s, List<String> wordDict) {
return false;
    }
}
