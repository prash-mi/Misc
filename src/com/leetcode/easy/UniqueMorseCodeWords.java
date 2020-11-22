package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        String[] ip = {"gin", "zen", "gig", "msg"};
        System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(ip));
    }

    String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        if (words==null){
            return 0;
        }
        Set<String> uniqueCodes = new HashSet<>();
        for (String word: words){
            StringBuffer code = new StringBuffer();
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                code.append(morseCodes[c-'a']);
            }
            uniqueCodes.add(code.toString());
        }
    return uniqueCodes.size();
    }
}
