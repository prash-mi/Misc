package com.leetcode.easy;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1Cur, TreeNode t2Cur) {//we will do preorder traversal and add t2's value in t1

        if (t1Cur == null && t2Cur == null){
            return null;
        }

        if (t1Cur == null || t2Cur == null){//return the non null node
            return t1Cur == null? t2Cur: t1Cur;
        }

        //both t1Cur and t2Cur are non null, add these to t1cur
        t1Cur.val = t1Cur.val + t2Cur.val;

        //recurse for left and right nodes
        t1Cur.left = mergeTrees(t1Cur.left, t2Cur.left);
        t1Cur.right = mergeTrees(t1Cur.right, t2Cur.right);

        return t1Cur;

    }
}
