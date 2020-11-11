package com.leetcode.medium;

import java.util.Arrays;

public class ValidSquare {

    public static void main(String[] args){
        System.out.println(new ValidSquare().validSquare(new int[]{1,1}, new int[]{5,3}, new int[]{3,5}, new int[]{7,7}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};
        //sorting the points by x co-ordinates. In case of tie, sorting by y co-ordinates
        //this will create an arrangement where points[0] is connected with points[1] and points[2], and points[3] is connected with points[1] and points[2]
        Arrays.sort(points, (pt1, pt2)-> pt1[0]!=pt2[0]?(pt1[0]-pt2[0]):(pt1[1]-pt2[1]));
        double armLen = getDistance(points[0], points[1]);
        return armLen!= 0 && getDistance(points[0], points[2]) == armLen && getDistance(points[3], points[1]) == armLen && getDistance(points[3], points[2]) == armLen &&
               getDistance(points[1], points[2]) == getDistance(points[0], points[3]) ;//all sides are equal and diagonals are equal
    }
    private double getDistance(int[] x, int[] y){
        return Math.sqrt(Math.pow(y[0]-x[0], 2) + Math.pow(y[1]-x[1], 2));
    }
}
