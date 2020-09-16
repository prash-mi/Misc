package com.leetcode.medium;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
            return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode cur, long min, long max) {
        if (cur==null){
            return true;
        }
        if (cur.val>min && cur.val <max){
            return isValidBSTHelper(cur.left, min, cur.val) && isValidBSTHelper(cur.right, cur.val, max);
        }else{
            return false;
        }
    }
}
