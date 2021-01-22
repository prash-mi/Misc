package com.leetcode.medium;



public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return checkSum(root, sum, 0);
    }
    private boolean checkSum(TreeNode cur, int targetSum, int runningSum) {
        if (cur == null){
            return false;
        }
        if (cur.left == null && cur.right == null && runningSum +cur.val == targetSum){//leaf node
            return true;
        }

        boolean left = checkSum(cur.left, targetSum, runningSum+cur.val);
        boolean right = checkSum(cur.right, targetSum, runningSum+cur.val);
        if (left||right){//found the target sum
            return true;
        }
        return false;
    }
}
