package com.leetcode.medium;

public class MaxAvgSubtree {
class TotalCnt{
    double total, cnt;
    double maxSubAvg;
    public TotalCnt(double total, double cnt){
        this.total = total;
        this.cnt = cnt;
    }
}
    public double maximumAverageSubtree(TreeNode root) {
        return getMaxAvgSub(root).maxSubAvg;
    }
    private TotalCnt getMaxAvgSub(TreeNode cur) {
        if (cur == null){
            return new TotalCnt(0,0);
        }
        TotalCnt left = getMaxAvgSub(cur.left);
        TotalCnt right = getMaxAvgSub(cur.right);
        double newAvgSubTree = (left.total+right.total+cur.val)/(left.cnt+right.cnt+1);
        TotalCnt newTc = new TotalCnt((left.total+right.total+cur.val), (left.cnt+right.cnt+1));
        newTc.maxSubAvg = Math.max(newAvgSubTree, Math.max(left.maxSubAvg, right.maxSubAvg));//max avg of left, right and the current subtree
        return newTc;
    }
}