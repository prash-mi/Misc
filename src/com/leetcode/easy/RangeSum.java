package com.leetcode.easy;

public class RangeSum {
    public int rangeSumBST(TreeNode cur, int low, int high) {
        if (cur==null){
            return 0;
        }
        int left = 0, right = 0;
        if (cur.val < low){
            right = rangeSumBST(cur.right, low, high);
        }else if(cur.val>high){
            left = rangeSumBST(cur.left, low, high);
        }else{
            left = rangeSumBST(cur.left, low, high);
            right = rangeSumBST(cur.right, low, high);
        }
        return left+right+(cur.val>=low && cur.val <=high?cur.val:0);
    }
}