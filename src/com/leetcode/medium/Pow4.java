package com.leetcode.medium;

public class Pow4 {
    public static void main(String[] args){
        System.out.println(new Pow4().isPowerOfFour(16));
        System.out.println(new Pow4().isPowerOfFour(24));
    }

    //for a 32 bit int its a O(1) solutions as max number of divisions possible are 16. 4^16 = 2^32
    public boolean isPowerOfFour(int num) {
    //keep dividing the number by 4, eventually the remainder should be 1
        while (num>=4){
            if (num%4 != 0){
                return false;
            }
            num = num/4;
        }
        return num ==1;
    }
}
