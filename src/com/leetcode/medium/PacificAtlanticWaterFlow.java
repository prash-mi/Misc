package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length==0){
            return result;
        }
        boolean[][] paciReach = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlReach = new boolean[matrix.length][matrix[0].length];
        for (int i =0; i < matrix[0].length; i++){//dfs from the top and bottom rows
            dfs(0, i, paciReach, matrix);
            dfs(matrix.length-1, i, atlReach, matrix);
        }
        for (int i =0; i < matrix.length; i++){//dfs from the first and last columns
            dfs(i, 0, paciReach, matrix);
            dfs(i, matrix[0].length-1, atlReach, matrix);
        }
    //find the intersection of both matrixes and return it
        for (int r = 0; r< matrix.length; r++){
            for (int c =0; c< matrix[0].length; c++){
                if (paciReach[r][c] && atlReach[r][c]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }
        return result;
    }
    int[][] moves = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    private void dfs(int x, int y, boolean[][] auxMax, int[][] matrix) {
        if (auxMax[x][y]){
            return;//this path is already visited
        }
        auxMax[x][y] = true;//visited
        for (int[] move: moves){
            int newX = x + move[0];
            int newY = y + move[1];
            if (canVisit(x, y, newX, newY, matrix)){
                dfs(newX, newY, auxMax, matrix);
            }
        }
    }
    private boolean canVisit(int x, int y, int newX, int newY, int[][] matrix) {
        return newX>=0 && newX<matrix.length && newY>=0 && newY < matrix[0].length && matrix[newX][newY] >= matrix[x][y];
    }
}
