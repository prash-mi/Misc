package com.leetcode.july;

public class IslandPerimeter {
    public static void main(String[] args){
        int[][] island = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};

        System.out.println(islandPerimeter(island));
    }

    public static int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;
        for(int row = 0; row <  grid.length; row++){
            for (int col = 0; col< grid[0].length; col++){
                if(grid[row][col] == 1){
                    int land = countLandSides(grid, row, col);
                    totalPerimeter += (4-land);
                }
            }
        }
        return totalPerimeter;
    }

    public static int countLandSides(int[][] grid, int row, int col){
        int land = 0;

        //check left
        if(col-1>=0 && grid[row][col-1] == 1){
            land++;
        }
        //check right
        if(col+1 < grid[0].length && grid[row][col+1] == 1){
            land++;
        }
        //check up
        if(row-1>=0 && grid[row-1][col] == 1){
            land++;
        }
        //check down
        if(row+1 < grid.length && grid[row+1][col] == 1){
            land++;
        }

        return land;
    }

}
