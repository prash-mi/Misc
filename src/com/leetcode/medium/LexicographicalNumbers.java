package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args){
        System.out.println(new LexicographicalNumbers().lexicalOrder(100));
        /*
        Output:
        [1, 10, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25,
        26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 4, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 5, 50,
        51, 52, 53, 54, 55, 56, 57, 58, 59, 6, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 7, 70, 71, 72, 73, 74, 75,
        76, 77, 78, 79, 8, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 9, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]
         */
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexRes = new ArrayList<>();
        dfs(0, n, lexRes);
        return lexRes;
    }

    void dfs(int cur, int n, List<Integer> res){
        for (int i =0; i <=9; i++){
            int tempCur = cur*10 +i;
            if (tempCur == 0){
                continue;
            }
            if (tempCur> n){
                return;
            }
            res.add(tempCur);
            dfs(tempCur, n, res);
        }
    }
}
