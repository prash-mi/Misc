package com.leetcode.july;

import java.util.HashSet;
import java.util.Set;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
public class UglyNumbers {
    public static void main(String[] args){


        System.out.println(nthUglyNumber(1213));
        System.out.println(nthUglyNumber(1690));

    }

    public static int nthUglyNumber(int n) {
        if(n < 1){return -1; }
        int[] uglNum = new int[n];
        uglNum[0] = 1;
        uglNum[0] = 2;
        uglNum[0] = 3;
        uglNum[0] = 4;
        uglNum[0] = 5;
        Set<Integer> uglSet = new HashSet<>();
        uglSet.add(1);uglSet.add(2);uglSet.add(3);uglSet.add(4);uglSet.add(5);
        int cnt = uglSet.size();//as we already have the these numbers
        while(cnt < n){
            cnt++;

            int l1 = 0, l2=0, l3=0;
            for(int i: uglNum){

                if(i == 0){
                    break;
                }

                int temp1 = 2*i, temp2=3*i, temp3=5*i;

                if(!uglSet.contains(temp1) && l1 == 0){
                    l1=temp1;
                }

                if(!uglSet.contains(temp2) && l2 == 0){
                    l2=temp2;
                }

                if(!uglSet.contains(temp3) && l3 == 0){
                    l3=temp3;
                }

                if(l1 !=0 && l2 != 0 && l3 != 0){
                    break;
                }
            }

            //the next number will be min of l1, l2 and l3
            int next = Integer.min(l1, Integer.min(l2, l3));

            uglSet.add(next);
            uglNum[cnt-1] = next;

        }

        return uglNum[cnt-1];//last index has the number

    }
    public static int nthUglyNumberBruitForce(int n) {
        if(n < 1){return -1; }
        int[] uglNum = new int[n];
        uglNum[0] = 1;
        Set<Integer> uglSet = new HashSet<>();
        uglSet.add(1);//uglSet.add(2);uglSet.add(3);uglSet.add(4);uglSet.add(5);
        int cnt = 1;//as we already have the these numbers
        while(cnt < n){
            cnt++;

            int l1 = 0, l2=0, l3=0;
            for(int i: uglNum){

                if(i == 0){
                    break;
                }

                int temp1 = 2*i, temp2=3*i, temp3=5*i;

                if(!uglSet.contains(temp1) && l1 == 0){
                    l1=temp1;
                }

                if(!uglSet.contains(temp2) && l2 == 0){
                    l2=temp2;
                }

                if(!uglSet.contains(temp3) && l3 == 0){
                    l3=temp3;
                }

                if(l1 !=0 && l2 != 0 && l3 != 0){
                    break;
                }
            }

            //the next number will be min of l1, l2 and l3
            int next = Integer.min(l1, Integer.min(l2, l3));

            uglSet.add(next);
            uglNum[cnt-1] = next;

        }

        return uglNum[cnt-1];//last index has the number

    }

}
