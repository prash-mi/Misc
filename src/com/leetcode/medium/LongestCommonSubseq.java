package com.leetcode.medium;

public class LongestCommonSubseq {
    //bottoms up dp - Time and space O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null||text2==null){
            return 0;
        }
        int[][] dpAux = new int[text1.length()+1][text2.length()+1];
        for (int r = 1; r< dpAux.length; r++){
            for (int c = 1; c< dpAux[0].length; c++){
                if (text1.charAt(r-1) == text2.charAt(c-1)){//take the diagonal value (implying longest sub without the current char) and add one as the char matches
                    dpAux[r][c] = dpAux[r-1][c-1] +1;
                }else{//take the longest sub without the current char on text1 and test 2
                    dpAux[r][c] = Math.max(dpAux[r-1][c], dpAux[r][c-1]);
                }
            }
        }
        return dpAux[dpAux.length-1][dpAux[0].length-1];//last index has the length
    }
}