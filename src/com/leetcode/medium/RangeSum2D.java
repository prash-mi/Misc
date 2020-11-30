package com.leetcode.medium;

public class RangeSum2D {

   /*
       Range Sum Query 2D - Immutable
       Time and space - O(m*n) for initialisation, and O(1) for query
    */

    int[][] sumMat;//this will hold the sum till a given x1, y1 point at sum[x1+1][x2+1]
    public RangeSum2D(int[][] matrix) {
        if (matrix==null || matrix.length==0){
            return;
        }
        sumMat = new int[matrix.length+1][matrix[0].length+1];
        for (int r=0; r< matrix.length; r++){
            int runningRowSum = 0;
            for (int c=0; c<matrix[0].length; c++){
                runningRowSum += matrix[r][c];
                sumMat[r+1][c+1] = runningRowSum + sumMat[r][c+1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sumMat==null || sumMat.length==0){
            return 0;
        }
        return sumMat[row2+1][col2+1] - sumMat[row1][col2+1] - (sumMat[row2+1][col1] - sumMat[row1][col1]);//sum if bigger rectangle - the areas which aren't included
    }
}
