package com.leetcode.medium;

//O(m*n) time and space
public class MinPathSumGrid {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */

    public int minPathSum(int[][] grid) {
        if (grid==null|| grid.length==0){
            return 0;
        }
        //process the first row and column first, as they can be reached from left or top respectively
        for (int r=1; r< grid.length; r++){
            grid[r][0] += grid[r-1][0];
        }
        for (int c=1; c< grid[0].length; c++){
            grid[0][c] += grid[0][c-1];
        }
        for (int r=1; r<grid.length; r++){
            for (int c=1; c< grid[0].length; c++){
                grid[r][c] += Math.min(grid[r-1][c], grid[r][c-1]);//we can come to the cur cell from top or bottom, select the path with the minimum sum
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

}
