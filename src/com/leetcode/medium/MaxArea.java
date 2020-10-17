package com.leetcode.medium;

public class MaxArea {

    public static void main(String[] args){
        int[][] grid1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid2 = {
                {0,0,1,0},
                {0,1,1,0},
                {0,0,1,0}};
        int[][] grid3 = {
                {0,0,0,0},
                {0,0,0,0}};
        System.out.println(new MaxArea().maxAreaOfIsland(grid3));
    }

    //O(m*n) time and O(?) space for recursion
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int maxArea = 0;
        for (int r = 0; r< grid.length; r++){
            for (int c = 0; c< grid[0].length; c++ ){
                if (grid[r][c] == 1){
                    maxArea = Math.max(maxArea, getCurAreaDFS(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    int[][] moves = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    private int getCurAreaDFS(int[][] grid, int r, int c) {
        grid[r][c] = -1;//visited
        int area = 0; 
        for (int[] move: moves){
            int newR = r+move[0];
            int newC = c+move[1];
            if(canVisit(grid, newR, newC)){
                int ar = getCurAreaDFS(grid, newR, newC);
                area += ar; 
            }
        }
        return area+1;//adding 1 for the current cell 
    }

    private boolean canVisit(int[][] grid, int newR, int newC) {
        return (newR>=0 && newR< grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]==1);
    }
}
