package com.leetcode.easy;

public class IncreasingBST {
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {

        TreeNode temp = new TreeNode(0);
        prev = temp;
        inOrderRelink(root);
        return temp.right;
    }

    private void inOrderRelink(TreeNode cur) {
        if (cur==null){
            return;
        }
        inOrderRelink(cur.left);

        cur.left=null;
        prev.right = cur;
        prev = cur;

        inOrderRelink(cur.right);
    }

}
