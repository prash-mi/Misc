package com.leetcode.easy;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        StringBuffer lcp = new StringBuffer();
        char c = '\0';
        for (int ind = 0; ind < strs[0].length(); ind++){
            c = strs[0].charAt(ind);
            if (!otherStrContains(c, strs, ind)){
                break;
            }else{
                lcp.append(c);
            }
        }
        return lcp.toString();
    }
    boolean otherStrContains(char c, String[] strs, int ind){
        for(int i=1; i < strs.length; i++){
            if (ind>=strs[i].length()|| strs[i].charAt(ind)!=c){
                return false;
            }
        }
        return true;
    }
}
