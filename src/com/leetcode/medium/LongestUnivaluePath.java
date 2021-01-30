package com.leetcode.medium;

public class LongestUnivaluePath {
    public static void main(String[] args){
        TreeNode o_1= new TreeNode(1);
        TreeNode f_1= new TreeNode(4);
        TreeNode f_2= new TreeNode(4);
        TreeNode f_3= new TreeNode(4);
        f_1.left=f_2;
        f_1.right=f_3;
        o_1.left=f_1;
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(o_1));
    }
    class LenAndPrevVal{
        int len = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
        LenAndPrevVal(int len, int prev){
            this.len = len;
            this.prev = prev;
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] max = {Integer.MIN_VALUE};
        getLongestUnivalPath(root,  max);
        return max[0]-1;//as getLongestUnivalPath returns the number of nodes and we have to return the number of edges
    }

    private LenAndPrevVal getLongestUnivalPath(TreeNode cur,  int[] globalMax) {
        if (cur==null){
            return new LenAndPrevVal(1, Integer.MIN_VALUE);
        }
        LenAndPrevVal left = getLongestUnivalPath(cur.left, globalMax);
        LenAndPrevVal right = getLongestUnivalPath(cur.right, globalMax);

        int lenThroughRoot = 0;
        if (left.prev == cur.val){//increase the lenght
            left.len++;
        }else{//reset the length and value
            left.len = 1;
            left.prev = cur.val;
        }
        if (right.prev == cur.val){
            right.len++;
        }else {
            right.len = 1;
            right.prev = cur.val;
        }

        if (left.prev == cur.val && right.prev == cur.val){//values on the left and right are the same
            lenThroughRoot = left.len + right.len -1;
        }
        globalMax[0] = Math.max(Math.max(lenThroughRoot, globalMax[0]), Math.max(left.len, right.len));//max if what we have seen till now
        return left.len>right.len?left:right;
    }
}
