package com.leetcode.medium;

public class CountNodesCompleteTree {

//O(log^2(n)) solution. That is we do log(n) work log(n) times in the worst case
    public int countNodes(TreeNode cur) {
        if (cur==null){
            return 0;
        }
        int leftDepth = getDepth(cur, true);
        int rightDepth = getDepth(cur, false);
        if (leftDepth == rightDepth){
            return (int)Math.pow(2, leftDepth)-1;
        }else {
            int leftCnt = countNodes(cur.left);
            int rightCnt = countNodes(cur.right);
            return leftCnt+rightCnt+1;
        }
    }
    private int getDepth(TreeNode cur, boolean left) {
        int depth = 0;
        while (cur!=null){
            depth++;
            cur = left?cur.left:cur.right;
        }
        return depth;
    }


    /*
    //O(n) solution
        public int countNodes(TreeNode cur) {
        if(cur == null){
            return 0;
        }

        return countNodes(cur.left) + countNodes(cur.right) + 1;
    }
     */
}
