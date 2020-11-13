package com.leetcode.medium;

//Maximum Difference Between Node and Ancestor
public class MaxDifference {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null){
            return 0;
        }
       return getMaxDiff(root, root.val, root.val);
    }

    private int getMaxDiff(TreeNode cur, int runningMin, int runningMax) {
        if (cur == null){
            return runningMax-runningMin;
        }
        int curMin = Math.min(cur.val, runningMin);
        int curMax = Math.max(cur.val, runningMax);

        int curLeftMaxDiff = getMaxDiff(cur.left, curMin, curMax);
        int curRightMaxDiff = getMaxDiff(cur.right, curMin, curMax);

        //the max diff between left and right will give the overall max diff when the recurssion rolls up
        return Math.max(curLeftMaxDiff, curRightMaxDiff);
    }


/*
 //Commenting this solution. It works in (n) and it is faster than 100% of leetcode submissions, but it's a bit complex! and a simpler approach is possible
 public int maxAncestorDiff(TreeNode root) {
        int[] minMaxDiff = maxAncestorDiffHelper(root);
        return minMaxDiff[2];
    }

    private int[] maxAncestorDiffHelper(TreeNode cur){
        if (cur == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};//{minValueTillCurrentLevel, maxValueTillCurrentLevel, maxDiffTillCurrentLevel}
        }
        int[] leftMinMaxDiff = maxAncestorDiffHelper(cur.left);
        int[] rightMinMaxDiff = maxAncestorDiffHelper(cur.right);

        int leftMaxDiff = Math.max(Math.abs(leftMinMaxDiff[0]==Integer.MAX_VALUE?0:leftMinMaxDiff[0]-cur.val),Math.abs(leftMinMaxDiff[1]==Integer.MIN_VALUE?0:leftMinMaxDiff[1] - cur.val));
        int rightMaxDiff = Math.max(Math.abs(rightMinMaxDiff[0]==Integer.MAX_VALUE?0:rightMinMaxDiff[0]-cur.val),Math.abs(rightMinMaxDiff[1]==Integer.MIN_VALUE?0:rightMinMaxDiff[1] - cur.val));
        int curMaxDif = Math.max(leftMaxDiff, Math.max(rightMaxDiff, Math.max(leftMinMaxDiff[2], rightMinMaxDiff[2])));

        int curMin = Math.min(leftMinMaxDiff[0], Math.min(rightMinMaxDiff[0], cur.val));
        int curMax = Math.max(leftMinMaxDiff[1], Math.max(rightMinMaxDiff[1], cur.val));

        return new int[]{curMin, curMax, curMaxDif};
    }*/
}