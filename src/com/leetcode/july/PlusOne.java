package com.leetcode.july;

public class PlusOne {

    public static void main(String[] args){
        int[] ip = {4,3,2,1};
        int[] op = plusOne(ip);
        for (int i: op) {
            System.out.print(i+", ");
        }
        System.out.println();
        ip = new int[]{9,9,9};
        op = plusOne(ip);
        for (int i: op) {
            System.out.print(i+", ");
        }

    }
    public static int[] plusOne(int[] digits) {
    int[] op = null;
    int carry = 1;//add one
    for(int i = digits.length-1; i>= 0; i--){//doing in place
        int temp = digits[i] + carry;
        if(temp > 9){
            carry = temp/10;
            digits[i] = temp % 10;
        }else{
            digits[i] = temp;
            carry = 0;
        }
    }

    if (carry == 0){//if carry isn't 0 then we will need to copy the digits in a new array 
        op = digits;
    }else {
        op = new int[digits.length+1];
        op[0] = carry;
        for (int i = 1; i < op.length; i++){
            op[i] = digits[i-1];
        }
    }

    return op;
    }
}

