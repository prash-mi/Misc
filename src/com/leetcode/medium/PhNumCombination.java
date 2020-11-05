package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhNumCombination {


    public static void main(String[] args){
        List<String> res = new PhNumCombination().letterCombinations("23");
        for (String s: res){
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> digitToChars = new HashMap<>();
        digitToChars.put(2, "abc");
        digitToChars.put(3, "def");
        digitToChars.put(4, "ghi");
        digitToChars.put(5, "jkl");
        digitToChars.put(6, "mno");
        digitToChars.put(7, "pqrs");
        digitToChars.put(8, "tuv");
        digitToChars.put(9, "wxyz");
        List<String> combinations = new ArrayList<>();
        if (digits==null||digits.length()==0){
            return combinations;
        }
        generateCombinations(digits, 0, new ArrayList<Character>(), combinations, digitToChars);
        return combinations;
    }

    private void generateCombinations(String digits, int dIndex, ArrayList<Character> buffer,
                                      List<String> result, Map<Integer, String> digitToChars) {

        if (buffer.size() == digits.length()){
            result.add(getString(buffer));
            return;
        }

        String curStr = digitToChars.get(Integer.parseInt(String.valueOf(digits.charAt(dIndex))));
        for(int i=0; i < curStr.length(); i++){
            buffer.add(curStr.charAt(i));
            generateCombinations(digits, dIndex+1, buffer, result, digitToChars);
            buffer.remove(buffer.size()-1);
        }

    }
    private String getString(ArrayList<Character> buffer){
        StringBuffer combination = new StringBuffer();
        for (char c:buffer){
            combination.append(c);
        }
        return combination.toString();
    }
}
