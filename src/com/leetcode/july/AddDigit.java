package com.leetcode.july;

public class AddDigit {
    public static void main(String[] args){

        /// 1234

        System.out.println(new AddDigit().addDigits(1234));
        System.out.println(new AddDigit().addDigits(99999));
        System.out.println(new AddDigit().addDigits(9));


    }

    public int addDigits2(int num) {
        if (num<=9) {
            return num;
        }
        int sum = 0;
            while (num > 0) {
                int temp = num % 10;
                num = num /10;
                sum += temp;

                if (num == 0 && sum > 9){
                    num = sum;
                    sum = 0;
                }
            }


        return sum;
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        else return num % 9;
    }
}
