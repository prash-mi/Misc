package com.leetcode.medium;

public class OneEditDistance {

    /*

    Insert exactly one character into s to get t.
    Delete exactly one character from s to get t.
    Replace exactly one character of s with a different character to get t.

     */

    //O(n) time and space
    public boolean isOneEditDistance(String s, String t) {
        if((s==null&&t==null) || (s.equals(t)) || Math.abs(s.length() - t.length()) >1){//one edit distance isn't possible
            return false;
        }
        //now s and t's length differ by just one
        if (s.length()==t.length()){//lets see if we cab replace a char
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i)!=t.charAt(i)){
                    s= s.substring(0, i)+t.charAt(i)+ (i+1<s.length()?s.substring(i+1, s.length()):"");
                    return s.equals(t);
                }
            }
        }else{//there is a single char diff, see if we can delete a char from the larger string
                String big = s.length()>t.length()?s:t;
                String small = s.length()>t.length()?t:s;

                for (int i=0; i < small.length(); i++){
                    if (small.charAt(i)!=big.charAt(i)){//delete ith char from big
                        big=big.substring(0, i)+ big.substring(i+1);
                        return small.equals(big);
                    }
                }
                //delete the last char of big and compare
                big = big.substring(0, big.length()-1);
                return small.equals(big);
        }
    return false;
    }
}
