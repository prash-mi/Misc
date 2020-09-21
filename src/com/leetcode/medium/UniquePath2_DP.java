package com.leetcode.medium;

//O(m*n) solution
public class UniquePath2_DP {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] grid2 = {{1}};
        int[][] grid3 = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(new UniquePath2_DP().uniquePathsWithObstacles(grid3));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        if ( grid == null || grid.length==0 || grid[grid.length-1][grid[0].length-1] ==1 || grid[0][0] == 1){
            return 0;
        }
        grid[0][0] = 1;//one way to reach the start point
        for (int i=1; i < grid.length; i++){//process first row, as it can be reached from only the top
            if (grid[i][0] == 1){//it can't be visited
                grid[i][0] = 0;//0 ways
            }else {
                grid[i][0] = grid[i-1][0];//copy the value from the top
            }
        }
        // same logic for columns
        for (int i=1; i < grid[0].length; i++){
            if (grid[0][i] == 1){
                grid[0][i] = 0;
            }else {
                grid[0][i] = grid[0][i-1];
            }
        }
        //process the remaining cells
        for (int i=1; i < grid.length; i++){
            for (int j = 1; j< grid[0].length; j++){
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                }else {//the number of ways to visit this is the number of ways to visit the top element + the number of ways to visit the left element
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];

    }
}
