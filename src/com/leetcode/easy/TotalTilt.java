package com.leetcode.easy;

public class TotalTilt {
    class SumAndTilt{
        int totalSum, totalTilt;
        public SumAndTilt(int totalSum, int totalTilt){
            this.totalSum = totalSum;
            this.totalTilt = totalTilt;
        }
    }
    public int findTilt(TreeNode root) {
        return findTotalTilt(root).totalTilt;
    }

    private SumAndTilt findTotalTilt(TreeNode cur){
        if (cur==null){
            return new SumAndTilt(0,0);
        }
        SumAndTilt lSumTilt = findTotalTilt(cur.left);
        SumAndTilt rSumTilt = findTotalTilt(cur.right);
        int newTotalSum = lSumTilt.totalSum + rSumTilt.totalSum + cur.val;
        int newTotalTilt = Math.abs(lSumTilt.totalSum-rSumTilt.totalSum) + lSumTilt.totalTilt + rSumTilt.totalTilt;
        return new SumAndTilt(newTotalSum, newTotalTilt);
    }
}
