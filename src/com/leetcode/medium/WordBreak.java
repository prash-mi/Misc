package com.leetcode.medium;

import java.util.*;

public class WordBreak {

//very intuitive BFS solution -  Time (n^3), space O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()==0){
            return false;
        }
        Set<String> dictionary = new HashSet<>(wordDict);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(0);//start with 0th char

        while (!bfs.isEmpty()){
            int cur = bfs.poll();
            if (cur == s.length()){//reached till the end, so a solution is possible
                return true;
            }
            if (visited.contains(cur)){//already visited
                continue;
            }
            for (int end = cur+1; end<= s.length(); end++){
                String sub = s.substring(cur, end);
                if (dictionary.contains(sub)){
                    bfs.add(end);//next word will start at the current end.
                }
            }
            visited.add(cur);
        }
        return false;
    }

    //DP approach, Time (n^3) - two loops and one inner substring call
    public boolean wordBreakDP(String s, List<String> wordDict) {
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




}
