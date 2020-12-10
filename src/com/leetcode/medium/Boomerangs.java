package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
You are given n points in the plane that are all distinct, where points[i] = [xi, yi].
A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 */
public class Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length<3){
            return 0;
        }
        int totalBoomerangCnt = 0;
        Map<Integer, Integer> disToCnt = new HashMap<>();

        for (int i = 0; i<points.length; i++){//explore all the combination if points
            for (int j=0; j< points.length; j++){
                if (i == j){//no point calculating distance from self
                    continue;
                }
                int dis = getDistance(points[i], points[j]);
                disToCnt.put(dis, disToCnt.getOrDefault(dis, 0)+1);
            }

            //now we have distance of ith point with every other points. now say two set of points - a, b and a, c have the same distance, then we have two boomerang tuples - [a, b, c] and [b, a, c]
            //that is the number of permutations of boomerangs between k points would be k * (k-1)

            //so now we will calculate the total number of boomerangs from the ith point
            int curBoomerrangs = 0;//number of boomerrangs through ith point
            for (int dis: disToCnt.keySet()){
                int pointCnt = disToCnt.get(dis);
                curBoomerrangs += (pointCnt * (pointCnt-1));
            }

            disToCnt.clear();//clearing the map for the next value of i

            totalBoomerangCnt += curBoomerrangs;

        }
        return totalBoomerangCnt;
    }

    private int getDistance(int[] point1, int[] point2) {
        return (int)(Math.pow(point1[0]-point2[0], 2) + Math.pow(point1[1]-point2[1], 2));
    }
}
