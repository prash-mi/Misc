package com.leetcode.medium;

public class RepeatedSubstring {
    public static void main(String[] args){
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abcdeabcde"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abcdeabcdf"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("a"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("aa"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("aaa"));
    }
    public boolean repeatedSubstringPattern(String s) {
        if (s==null||s.length()<2){
            return false;
        }
        for(int subLen = s.length()/2; subLen>0;subLen--){
            if (s.length()%subLen!=  0){
                continue;
            }
            int subStrCnt = s.length()/subLen;
            for (int block = 0; block<subStrCnt-1; block++){
                String curBlock = s.substring(block*subLen, (block*subLen)+subLen);
                String nextBlock = s.substring((block*subLen)+subLen, (block*subLen)+(subLen*2));
                if(!(curBlock.hashCode() == nextBlock.hashCode() && curBlock.equals(nextBlock))){
                    break;//try different subLength now
                }
                if (block == subStrCnt-2){//matched till the last block
                    return true;
                }
            }
        }
        return false;
    }
}