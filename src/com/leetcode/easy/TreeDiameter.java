package com.leetcode.easy;


public class TreeDiameter {
    class MaxDia{
        int max = 0;
    }
    public int diameterOfBinaryTree(TreeNode cur){
        MaxDia maxWrapper = new MaxDia();
        diameterOfBinaryTreeHelper(cur, maxWrapper);
        return maxWrapper.max;
    }

    private int diameterOfBinaryTreeHelper(TreeNode cur, MaxDia maxWrapper ){
        if(cur==null){
            return 0;
        }
        int lHeight = diameterOfBinaryTreeHelper(cur.left, maxWrapper);
        int rHeight = diameterOfBinaryTreeHelper(cur.right, maxWrapper);

        maxWrapper.max = Math.max(maxWrapper.max, (lHeight+rHeight));
        return Math.max(lHeight, rHeight)+1;
    }
}
