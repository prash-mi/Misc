package com.leetcode.easy;

public class ReverseVowels {
    public String reverseVowels(String s) {
    if (s==null || s.length()<=1){
        return s;
    }
    char[] str = s.toCharArray();
    int left=0, right = str.length-1;
    while(left<right){
        if (isVowel(str[left]) && isVowel(str[right])){
            char t = str[left];
            str[left] = str[right];
            str[right] = t;
            left++;
            right--;
        }else if(isVowel(str[left])){
            right--;
        }else if(isVowel(str[right])){
            left++;
        }else{//both are not vowels
            left++;
            right--;
        }
    }
    return new String(str);
    }
    boolean isVowel(char c){
        return c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'||
                c == 'A' ||c == 'E' ||c == 'I' ||c == 'O' ||c == 'U';
    }
}
