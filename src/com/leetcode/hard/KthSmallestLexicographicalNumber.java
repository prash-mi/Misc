package com.leetcode.hard;

import com.leetcode.medium.LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

/*
Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */

//THIS LOGIC OF ACTUALLY GENERATING THE NUMBERS IN LEXICAL ORDER TILL THE KTH NUMBER IS BREAKING FOR LARGE TESTCASES!!

public class KthSmallestLexicographicalNumber {
class LexOrderAndNum{
    int lexOrder=0;
    int num = -1;
}
    public static void main(String[] args) {
        System.out.println(new KthSmallestLexicographicalNumber().findKthNumber(13, 2));
    }

    public int findKthNumber(int n, int k) {
        List<Integer> lexRes = new ArrayList<>();
        LexOrderAndNum lexOrderNum = new LexOrderAndNum();
        dfs(0, n, lexOrderNum, k);
        return lexOrderNum.num;
    }

    void dfs(int cur, int n, LexOrderAndNum lexOrderNum, int k){

        for (int i =0; i <=9; i++){
            int tempCur = cur*10 +i;
            if (tempCur == 0){
                continue;
            }
            if (tempCur> n){
                return;
            }

            lexOrderNum.lexOrder++;

            if (lexOrderNum.lexOrder == k){
                lexOrderNum.num = tempCur;
            }
            if (lexOrderNum.num!= -1){
                return;
            }

            dfs(tempCur, n, lexOrderNum, k);
        }
    }
}
