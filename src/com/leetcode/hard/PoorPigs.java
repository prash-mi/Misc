package com.leetcode.hard;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        /*
            the given number of buckets will be divided in a row*col grid
            a pig will test row-1 and col-1 buckets simultaniusly, minus 1 because say out of 5 if pig didn't die till 4th bucket then 5th is the poisonous
            so the intersection of row and col will give the poisonous bucket

            the same idea will be generalized for when there will be more than 2 pigs, that is grid will be 3 dimentional and so on.
         */

        int maxConcurrentBucketsPerPig = minutesToTest/minutesToDie +1; //take an example 60/15 + 1 = 5, that is pig will test 4 buckets and 5th is implicitly tested
        int pig = 0;
        while(Math.pow(maxConcurrentBucketsPerPig, pig) < buckets){//in the given example, 1 pig can test 5 buckets (60/15 + 1 = 5), 2 can test 25, 3 can upto 125
            pig++;
        }
        return pig;
    }
}
