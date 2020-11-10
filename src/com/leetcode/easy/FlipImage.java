package com.leetcode.easy;

public class FlipImage {
    /*
     Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     */
    public static void main(String[] args){
        int[][] ip = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] res = new FlipImage().flipAndInvertImage(ip);
        for (int r = 0; r< res.length; r++){
            for (int c = 0; c< res[0].length; c++){
                System.out.print(res[r][c]);
            }
            System.out.println();
        }
    }
    //Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
    public int[][] flipAndInvertImage(int[][] img) {
        int colLen = img[0].length;
        for(int r=0; r<img.length; r++){
            for (int c=0; c<(colLen+1)/2;c++){
                int temp = img[r][c];
                img[r][c] = invert(img[r][colLen -1 - c]);
                img[r][colLen -1 - c] = invert(temp);
            }
        }
        return img;
    }
    private int invert(int p){
        return p ==0?1:0;
    }
}