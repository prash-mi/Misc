package com.leetcode.easy;

public class BalancedTree {
    class Balanced{
        boolean isBalanced = true;
        int maxDepth=Integer.MIN_VALUE;
        Balanced( int maxDepth){
            this.maxDepth = maxDepth;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root ==null){
            return true;
        }
        return checkBalanced(root, 0).isBalanced;
    }

    Balanced checkBalanced(TreeNode cur, int depth){
        if (cur==null){
            return new Balanced(depth);
        }

        Balanced left = checkBalanced(cur.left, depth+1);
        Balanced right = checkBalanced(cur.right, depth+1);
        if (!left.isBalanced||!right.isBalanced){//tree isn't balanced is already found
            return !left.isBalanced?left:right;
        }

        Balanced curBalanced = new Balanced(Math.max(left.maxDepth, right.maxDepth));
        curBalanced.isBalanced = Math.abs(left.maxDepth - right.maxDepth) <= 1;

        return curBalanced;

    }
}
