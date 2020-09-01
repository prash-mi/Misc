package com.leetcode.aug;
/*
 Given the API rand7 which generates a uniform random integer in the range 1 to 7,
 write a function rand10 which generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call any other API.
 Please don't use the system's Math.random().
 */
public class Rand10 {

    public int rand10() {

        //if we call rand7 twice then we can get random number till 7*7 = 47. It's similar to rolling two 7sided dices
        //if we consider numbers till 40 as it's the largest number divisible by 10, then we can use a logic like say we get  12 then we return 2

        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public int rand7() {
        return 0;
    }
}
