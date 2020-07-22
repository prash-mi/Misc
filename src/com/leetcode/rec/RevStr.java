package com.leetcode.rec;

public class RevStr {
    public static void main(String[] args){
        char[] s = {'h', 'e', 'l', 'l', 'o'};
          new RevStr().revHelper(s, 0, s.length-1);
         for(char c:s){
             System.out.print(c);
         }
    }
    public void revHelper(char[] s, int left, int right){
        if(left >= right){
             return;
        }
        char temp = s[right];
        s[right]=s[left];
        s[left] = temp;
         revHelper(s,++left, --right);
    }
}
