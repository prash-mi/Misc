package com.leetcode.aug;

public class Palindrome {

    public static void main(String[] args){
        System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Palindrome().isPalindrome("race a car"));
    }
    public boolean isPalindrome(String s) {

        if(s == null || s.isEmpty() || s.length()==1){
            return true;
        }

        int left = 0, right = s.length()-1;
        int lChar, rChar;
        while(left<right){
            if(s.charAt(left) == ' '|| !((s.charAt(left)>=65 && s.charAt(left)<=90)
                    || (s.charAt(left)>=97 && s.charAt(left)<=122)|| (s.charAt(left)>=48 && s.charAt(left)<=57)) ){
                left++;
                continue;
            }
            if(s.charAt(right) == ' '|| !((s.charAt(right)>=65 && s.charAt(right)<=90)
                    || (s.charAt(right)>=97 && s.charAt(right)<=122)|| (s.charAt(right)>=48 && s.charAt(right)<=57)) ){
                right--;
                continue;
            }

            //now char is not a space

            if(s.charAt(left)<97 && s.charAt(left)>57){
                lChar= s.charAt(left) - 65;
            }else{
                lChar= s.charAt(left) - 97;
            }

            if(s.charAt(right)<97&& s.charAt(right)>57){
                rChar= s.charAt(right) - 65;
            }else{
                rChar= s.charAt(right) - 97;
            }

            if(lChar != rChar){
                return false;
            }

            left++;
            right--;

        }
        return true;
    }
}
