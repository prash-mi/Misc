package com.leetcode.aug;

import java.util.ArrayList;
import java.util.List;

public class PascleTriangle {
    public static void main(String[] args){
        List<Integer> row = new PascleTriangle().getRow(3);
        for (int i:row){
            System.out.print(i+" ");
        }

    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(), nextRow = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0){
            return row;
        }
        for (int i = 1 ; i<= rowIndex; i++){
            nextRow.add(1);
            for (int j = 0; j < row.size()-1; j++){
                nextRow.add(row.get(j)+row.get(j+1));
            }
            nextRow.add(1);

            row = nextRow;
            nextRow = new ArrayList<>();
        }

       return row;
    }
}
