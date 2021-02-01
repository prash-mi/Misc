package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascleTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas = new ArrayList<>();
        if (numRows<=0){
            return pas;
        }
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        pas.add(row1);
        if (numRows==1){
            return pas;
        }

        for (int r=2; r<=numRows; r++){
            List<Integer> last = pas.get(pas.size()-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i=0; i<last.size()-1; i++){
                cur.add(last.get(i)+last.get(i+1));
            }
            cur.add(1);
            pas.add(cur);
        }

    return pas;
    }
}
