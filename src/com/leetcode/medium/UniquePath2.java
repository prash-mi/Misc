package com.leetcode.medium;

//This uses backtracking and has a timecomplexity of O(2^(m*n)). There are two decision at every cell
public class UniquePath2 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] grid2 = {{1}};
        int[][] grid3 = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(new UniquePath2().uniquePathsWithObstacles(grid3));
    }

    private int[][] moves = {{1,0},{0,1}};//down and right

    public int uniquePathsWithObstacles(int[][] grid) {
        if ( grid == null || grid.length==0 || grid[grid.length-1][grid[0].length-1] ==1 || grid[0][0] == 1){
            return 0;
        }
        int[] start = {0,0};
        return getUniquePaths(start, grid);
    }


    private int getUniquePaths(int[] cur, int[][] grid) {
        if (cur[0] == grid.length-1 && cur[1] ==grid[0].length-1){//reached the end
            return 1;
        }

        int paths=0;
        for (int[] move: moves){
            int[] next = {cur[0]+move[0], cur[1]+move[1]};
            if (isValid(next, grid)){
                if (next[0]!=grid.length-1 && next[1]!=grid[0].length-1){//do not mark the end point visited
                    grid[next[0]][next[1]] = 1;//mark visited, so that the robot doesn't go back
                }
                int path = getUniquePaths(next, grid);
                paths+= path;
                grid[next[0]][next[1]] = 0;
            }
        }
        return paths;
    }

    private boolean isValid(int[] next, int[][] grid) {
        return (next[0] >= 0 && next[0]<grid.length && next[1] >= 0
                && next[1]<grid[0].length && grid[next[0]][next[1]]!=1);//1 is obstacle
    }
}
