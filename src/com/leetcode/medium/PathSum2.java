package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
/*
Time:  O(N^2) - In the worst case there will be n/2 leaves and for all of those leaves we will do deep copy and sum check

 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        getPaths(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void getPaths(TreeNode cur, int sum, ArrayList<Integer> buff, List<List<Integer>> res) {

        if (cur==null){
            return;
        }
        if (cur.left == null && cur.right == null && sum(buff) + cur.val == sum){//reached a leafnode with the required sum. The leaf value isn't added in the buffer yet to taking that into account as well
            List<Integer> temp =  new ArrayList<>(buff);
            temp.add(cur.val);
            res.add(temp);//deep copy
            return;
        }

        buff.add(cur.val);
        getPaths(cur.left, sum, buff, res);
        getPaths(cur.right, sum, buff, res);
        buff.remove(buff.size()-1);//remove the last index, backtrack
    }

    private int sum(ArrayList<Integer> buff) {
        int sum = 0;
        for (int i: buff){
            sum+= i;
        }
        return sum;
    }
}
