package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

//O(n log n) solution
public class CarPooling {
    public static void main(String[] args) {
        int[][] trips1 = {{2,1,5},{3,3,7}};
        int[][] trips2 = {{3,2,7},{3,7,9},{8,3,9}};
        int[][] trips3 = {{3,6,9},{10,2,3},{1,6,8},{2,1,6},{9,3,9}};
       // System.out.println(new CarPooling().carPooling(trips1, 5));
        System.out.println(new CarPooling().carPooling(trips2, 11));//true
        System.out.println(new CarPooling().carPooling(trips3, 12));//false
    }
    /*
    Input: trips = [[2,1,5],[3,3,7]], capacity = 5
    Output: true
     */
    public boolean carPooling(int[][] trips, int capacity) {
    //sort trips by the starting point
        if (trips==null||trips.length==0||trips[0][0]>capacity){
            return false;
        }
        Arrays.sort(trips, (o1, o2) -> o1[1]-o2[1]);
        PriorityQueue<int[]> tripEnds = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);//min priority queue ordered by the trip end points
        int curPassengers = 0;
        for (int i = 0; i <trips.length; i++){//start from 1 and compare it with the previous
            while (!tripEnds.isEmpty() && tripEnds.peek()[2]<=trips[i][1]){//the element with earliest endLocation <= current start location, meaning the passengers will now leave the vehicle
                int[] endTrip = tripEnds.poll();
                curPassengers -= endTrip[0];//passenger left the vehicle
            }
            curPassengers += trips[i][0];
            tripEnds.add(trips[i]);
            if (curPassengers>capacity){
                return false;
            }
        }
    return true;
    }

}
