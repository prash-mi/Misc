package com.leetcode.medium;

public class UniquePath_DP {
    //O(m*n) time and space
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;//one way to reach the start point
        for (int i=1; i < grid.length; i++){//process first row, as it can be reached from only the top
                grid[i][0] = grid[i-1][0];//copy the value from the top
        }
        // same logic for columns
        for (int i=1; i < grid[0].length; i++){
                grid[0][i] = grid[0][i-1];
        }
        //process the remaining cells
        for (int i=1; i < grid.length; i++){
            for (int j = 1; j< grid[0].length; j++){//the number of ways to visit this is the number of ways to visit the top element + the number of ways to visit the left element
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
