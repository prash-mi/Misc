package com.leetcode.july;

public class ReverseWords {
    public static void main(String[] args){
     //   System.out.println(reverseWords("a good   example"));

        System.out.println(reverseWords("  hello world!  "));
    }
    public static String reverseWords(String s) {
    if(s == null || s.equals("")){
        return s;
    }

    String[] splt = s.split(" ");

    StringBuffer revStr = new StringBuffer();

    for (int i = splt.length-1; i >=0; i--){
        if (splt[i]!=null && !splt[i].equals("") ){
            revStr.append(splt[i]+ (i>0?" ":""));
        }
    }

    String rev = revStr.toString();

    return rev.endsWith(" ")?rev.trim():rev;
    }
}
