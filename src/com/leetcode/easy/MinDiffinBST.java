package com.leetcode.easy;

public class MinDiffinBST {
    class MinDiff{
        int val = Integer.MAX_VALUE;
        TreeNode prev = null;
    }
    public int minDiffInBST(TreeNode root) {
        MinDiff m = new MinDiff();
        dfs( root, m);
        return m.val;
    }

    void dfs(TreeNode cur, MinDiff m){//inorder traversal
        if (cur==null){
            return;
        }
        dfs(cur.left, m);
        if (m.prev!=null){
            m.val = Integer.min(m.val, Math.abs(m.prev.val-cur.val));
        }
        m.prev = cur;//the numbers will be in order
        dfs(cur.right, m);
    }
}
