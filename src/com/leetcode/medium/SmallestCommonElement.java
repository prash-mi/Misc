package com.leetcode.medium;
/*
Find Smallest Common Element in All Rows
Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5

 */
public class SmallestCommonElement {

    public static void main(String[] args){
        int[][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        System.out.println(new SmallestCommonElement().smallestCommonElement(mat));
    }

    //go through the first row, search for every element in the remaining rows, the first common element is the smallest common element as well
    //Time O(m * log(m-1 * n-1)), space O(1)
    public int smallestCommonElement(int[][] mat) {
        if (mat== null || mat.length == 0){
            return -1;
        }
        for (int col = 0; col < mat[0].length; col++){
            int matchingRowCnt = 1;// as it's there in the first row for sure
            for (int row = 1; row < mat.length; row++){
                if (rowContainsValue(mat[row], mat[0][col])){
                    matchingRowCnt++;
                }
            }
            if (matchingRowCnt == mat.length){
                return mat[0][col];
            }
        }
    return -1;
    }

    private boolean rowContainsValue(int[] row, int val) {//binary search for val in row
        int left = 0, right = row.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (row[mid] == val){
                return true;
            }else if (row[mid] < val){//go right
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
    return false;
    }
}
