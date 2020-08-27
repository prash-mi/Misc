package com.leetcode.aug;

public class SumOfLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }

    public int  sumOfLeftLeavesHelper(TreeNode cur, boolean cameLeft){
        if (cur ==null){
            return 0;
        }
        if (cur.left == null && cur.right == null && cameLeft){
            return cur.val;//this is a left node
        }
        int leftCnt = sumOfLeftLeavesHelper(cur.left, true);
        int rightCnt = sumOfLeftLeavesHelper(cur.right, false);
        return leftCnt+rightCnt;
    }
}
