package com.leetcode.easy;

public class LongestConsecutiveSequence {
    class LongestLen{
        int len = 1;
    }
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        LongestLen l = new LongestLen();
        getLongCons(root, l, Integer.MIN_VALUE, 1);
        return l.len;
    }

    void getLongCons(TreeNode cur, LongestLen l, int prev, int consSeqLen){
        if (cur == null){
            return;
        }

        if (cur.val == prev+1){//consecutive increasing
            consSeqLen++;
            l.len = Math.max(l.len, consSeqLen);
        }else {//non increasing, reset the count
            consSeqLen = 1;//reset
        }

        getLongCons(cur.left, l, cur.val, consSeqLen);
        getLongCons(cur.right, l, cur.val, consSeqLen);
    }
}