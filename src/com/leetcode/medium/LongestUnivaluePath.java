package com.leetcode.medium;

public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] max = {Integer.MIN_VALUE};
        getLongestUnivalPath(root, Integer.MIN_VALUE, max);
        return max[0];
    }

    private int getLongestUnivalPath(TreeNode cur, int prevVal, int[] globalMax) {
        if (cur==null){
            return 0;
        }

        int left = getLongestUnivalPath(cur.left, cur.val, globalMax);
        int right = getLongestUnivalPath(cur.right, cur.val, globalMax);

        //if (prevVal == cur.left)


    }
}
