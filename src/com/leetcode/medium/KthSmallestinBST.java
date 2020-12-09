package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestinBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList();
        inOrder(root, res, k);
        return res.get(res.size()-1);
    }
    void inOrder(TreeNode cur, List<Integer> res, int k){
        if(cur == null || res.size()>=k){
            return;
        }
        inOrder(cur.left, res, k);
        if(res.size()<k){
            res.add(cur.val);
        }


        inOrder(cur.right, res, k);
    }
}
