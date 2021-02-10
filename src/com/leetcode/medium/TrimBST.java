package com.leetcode.medium;

public class TrimBST {
    public TreeNode trimBST(TreeNode cur, int low, int high) {
        if (cur==null){
            return null;
        }

        if (cur.val<low){
            return trimBST(cur.right, low, high);//see if we have a bigger value on the right, the left tree is completely discarded
        }
        if (cur.val>high){
            return trimBST(cur.left, low, high);
        }
        cur.left = trimBST(cur.left, low, high);
        cur.right = trimBST(cur.right, low, high);
        return cur;
    }
}
